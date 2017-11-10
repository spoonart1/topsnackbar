import android.app.Activity
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView

/**
 * Created by Lafran on 11/9/17.
 */
class TopSnackBar(activity: Activity, text: String, subtext: String, clickOnDismiss: Boolean = false) {
    val DELAYED_ANIMATION_TO_DISMISS = 1500L
    private var viewGroup: ViewGroup? = null
    private var context = activity
    private var text = text
    private var subText = subtext
    private var clickOnDismiss = clickOnDismiss

    companion object {
        var isShowing = false
        var isOneShotEnabled = true
        private var contentView: View? = null
    }

    init {
        setup()
        show()
    }

    private fun setup() {
        if (context is Activity) {
            viewGroup = context.window.decorView as ViewGroup
            if (viewGroup != null) {
                initContent()
            }
        } else {
            throw Error("context must be an activity!")
        }
    }

    private fun initContent() {
        if (text.isEmpty())
            return

        if(contentView == null) {
            contentView = View.inflate(context, R.layout.layout_top_snack_bar, null)
            val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            contentView!!.layoutParams = params
        }

        val snackTitle = Finder.findById<TextView>(contentView!!, R.id.tv_snack_title)
        val snackSubTitle = Finder.findById<TextView>(contentView!!, R.id.tv_snack_subtitle)

        snackTitle.text = text

        if (!subText.isEmpty())
            snackSubTitle.text = subText

        if(clickOnDismiss){
            contentView!!.setOnClickListener{ view ->
                animateHide()
            }
        }
    }

    fun show() {
        if(isOneShotEnabled){
            showOnShot()
        }
        else{
            showBurst()
        }
    }

    fun update() : TopSnackBar{
        initContent()
        return this
    }

    fun dismis(delay:Long){
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                animateHide()
            }
        }, delay)
    }

    private fun showOnShot(){
        if(!isShowing){
            viewGroup!!.addView(contentView)
            animate()
        }
    }

    private fun showBurst(){
        viewGroup!!.addView(contentView)
        animate()
    }

    private fun animate() {
        animateShow()
        if (!clickOnDismiss){
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    animateHide()
                }
            }, DELAYED_ANIMATION_TO_DISMISS)
        }
    }

    private fun animateShow() {
        val anim = AnimationUtils.loadAnimation(context, R.anim.snack_bar_show)
        contentView?.startAnimation(anim)
        TopSnackBar.isShowing = true
    }

    private fun animateHide() {
        val anim = AnimationUtils.loadAnimation(context, R.anim.snack_bar_hide)
        contentView?.startAnimation(anim)

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                viewGroup?.removeView(contentView)
                TopSnackBar.isShowing = false
            }

        })
    }
}
