# AdvancedPathways
 Extra Credit-Advanced Topics 1-3
 App written in Kotlin, featuring Notifications, Advanced Graphics, and Animation
 The layout includes a title TextView, 
 an ImageView displaying an image, 
 and a Button to show a notification & animation.
 
-------------Description of App's Working-------------------
To add animation to this layout,used Android's Animation API.
when the Button is clicked, the animation starts and show notification.
To add a notification to the app, used the NotificationManager API.
This code creates a notification channel and a notification with a title, text, and small icon.
To animate the ImageView :code retrieves the ImageView from the layout
and creates an ObjectAnimator to rotate it 360 degrees over 1 second.