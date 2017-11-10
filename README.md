# topsnackbar
Top Snack Bar (kotlin)


`How to Use`
 ``` copy and locate files ```
 
 `Usage`
 ``` 
 
@parameter (context:Activity, title:String, subtitle:String, clickOnDismiss = false)

without dissmiss on click
TopSnackBar(this@MainActivity, "Notifikasi", message) 

with dismiss on click
TopSnackBar(this@MainActivity, "Notifikasi", message, true) 

update when still showing on top bar
TopSnackBar(this@MainActivity, "Notifikasi", "Update text")
                                .update()
                                .dismis(1000) //delayed dismiss after updating text
                                
                                
showing only one TopSnackBar
TopSnackBar.isOneShotEnabled = true //default

showing burst TopSnackBar
TopSnackBar.isOneShotEnabled = false

```
