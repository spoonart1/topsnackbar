# topsnackbar
Top Snack Bar (kotlin)


# How to Use
 ``` copy and locate files ```
 
# Usage
@parameter (context:Activity, title:String, subtitle:String, clickOnDismiss:Boolean = false, autoShow:Boolean = true)

-> without dissmiss on click
``` TopSnackBar(this@MainActivity, "Notifikasi", message) ```

-> with dismiss on click
``` TopSnackBar(this@MainActivity, "Notifikasi", message, true) ```

-> update when still showing on top bar
``` TopSnackBar(this@MainActivity, "Notifikasi", "Update text")
                                .update()
                                .dismis(1000) //delayed dismiss after updating text
```
                                
                                
-> showing only one TopSnackBar, set before initiate instance
``` TopSnackBar.isOneShotEnabled = true //default ```

-> showing burst TopSnackBar
``` TopSnackBar.isOneShotEnabled = false ```


```
-> change background, (this must set autoshow = false)
TopSnackBar(this, "Your Title", "Your subtitle here...", clickOnDismiss = true, autoShow = false)
                        .background(TopSnackBar.ALERT_COLOR)
                        .show()
```


### NO NEED LICENSE, FREE TO USE!!, FREE TO UPDATE!!, FREE FOR ALL ###
