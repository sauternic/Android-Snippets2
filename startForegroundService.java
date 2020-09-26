
MainActivity.java:
////////////////////////////////////////////////////////////////////////
public void onClick_Start(View view) {
        Intent intent = new Intent(this, MyService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    public void onClick_Stop(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
///////////////////////////////////////////////////////////////////////////


MyService.java:
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            final String channelId = "channelId_1234";

            //Nur nötig wenn sich die Aktivity beim Tippen der Notification öffnen soll!&&&&&&&&&&&&&&&&&&&&&&&&&&
            Intent intent1 = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivities(this, 1 ,new Intent[]{intent1}, 0);
            //Fertig &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

            final NotificationChannel notificationChannel = new NotificationChannel(
                    channelId,
                    getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
                Notification notification = new NotificationCompat.Builder(this, channelId)
                        .setContentTitle("TestTitle")
                        .setContentText("TestText")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent)
                        .build();

                startForeground(5, notification);
            }
            return START_STICKY;
        }
        return super.onStartCommand(intent, flags, startId);
    }
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%