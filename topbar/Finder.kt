import android.app.Activity
import android.app.Dialog
import android.support.annotation.IdRes
import android.view.View

/**
 * Created by Doconium on 13/07/2017.
 */

object Finder {

    fun <T : View> findById(view: View, @IdRes id: Int): T {
        return view.findViewById<View>(id) as T
    }

    fun <T : View> findById(activity: Activity, @IdRes id: Int): T {
        return activity.findViewById<View>(id) as T
    }

    fun <T : View> findById(dialog: Dialog, @IdRes id: Int): T {
        return dialog.findViewById<View>(id) as T
    }
}
