package com.zezoo.qurankarem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class PlayerService extends Service implements OnCompletionListener,
		OnPreparedListener, OnErrorListener, OnSeekCompleteListener,
		OnInfoListener, OnBufferingUpdateListener {
	MediaPlayer mp2 = new MediaPlayer();
	String current_name, current_reader, name_of_song;
	ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	int current_index, current_index_1;
	SongsManager songManager;
	boolean isPlay;
	RemoteViews bigViews, views;

	private static final String LOG_TAG = "ForegroundService";

	@Override
	public void onCreate() {
		try {
			mp2.setOnCompletionListener(this);
			mp2.setOnPreparedListener(this);
			mp2.setOnErrorListener(this);
			mp2.setOnSeekCompleteListener(this);
			mp2.setOnInfoListener(this);
			mp2.setOnBufferingUpdateListener(this);
			mp2.reset();
		} catch (Exception e) {

		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		current_name = intent.getExtras().getString("current_song");
		current_reader = intent.getExtras().getString("current_reader");
		current_index = intent.getExtras().getInt("current_index");
		current_index_1 = intent.getExtras().getInt("current_index_1");
		name_of_song = current_name + " - " + current_reader;
		songManager = new SongsManager(current_index_1);
		songsList = songManager.getPlayList();
		if (intent.getAction().equals(Constants.ACTION.STARTFOREGROUND_ACTION)) {
			showNotification();
			Toast.makeText(this, "Œœ„… «· ‘€Ì· «·Œ«—ÃÌ  ⁄„·",
					Toast.LENGTH_SHORT).show();
		} else if (intent.getAction().equals(Constants.ACTION.PREV_ACTION)) {
			Toast.makeText(this, "«·”«»ﬁ", Toast.LENGTH_SHORT).show();
			Log.i(LOG_TAG, "«·”«»ﬁ");
		} else if (intent.getAction().equals(Constants.ACTION.PLAY_ACTION)) {
			Toast.makeText(this, " ‘€Ì·", Toast.LENGTH_SHORT).show();
			Log.i(LOG_TAG, " ‘€Ì·");
			if (mp2.isPlaying()) {
				if (mp2 != null) {
					mp2.pause();
					// Changing button image to play button
					views.setImageViewResource(R.id.status_bar_play , R.drawable.apollo_holo_dark_play);
					bigViews.setImageViewResource(R.id.status_bar_play , R.drawable.apollo_holo_dark_play);
				}
			} else {
				// Resume song
				if (mp2 != null) {
					mp2.start();
					// Changing button image to pause button
					views.setImageViewResource(R.id.status_bar_play , R.drawable.apollo_holo_dark_pause);
					bigViews.setImageViewResource(R.id.status_bar_play , R.drawable.apollo_holo_dark_pause);
				}
			}
		} else if (intent.getAction().equals(Constants.ACTION.NEXT_ACTION)) {
			Toast.makeText(this, "«· «·Ì", Toast.LENGTH_SHORT).show();
			Log.i(LOG_TAG, "«· «·Ì");
		} else if (intent.getAction().equals(
				Constants.ACTION.STOPFOREGROUND_ACTION)) {
			Log.i(LOG_TAG, "≈€·«ﬁ Œœ„… «· ‘€Ì· «·Œ«—ÃÌ");
			Toast.makeText(this, "≈€·«ﬁ Œœ„… «· ‘€Ì· «·Œ«—ÃÌ",
					Toast.LENGTH_SHORT).show();
			stopForeground(true);
			stopSelf();
		}
		try {
			playPauseSong();
		} catch (Exception e) {

		}
		return START_STICKY;
	}

	Notification status;

	private void showNotification() {
		// TODO Auto-generated method stub
		// Using RemoteViews to bind custom layouts into Notification
		try {
			views = new RemoteViews(getPackageName(),
					R.layout.activity_notification);
			bigViews = new RemoteViews(getPackageName(),
					R.layout.activity_notification_expanded);

			// showing default album image
			views.setImageViewResource(R.id.status_bar_album_art,
					R.drawable.notification_icon);
			bigViews.setImageViewResource(R.id.status_bar_album_art,
					R.drawable.notification_icon);

			Intent notificationIntent = new Intent(this,
					AndroidBuildingMusicPlayerActivity.class);
			notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
			notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_CLEAR_TASK);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
					notificationIntent, 0);

			Intent previousIntent = new Intent(this, PlayerService.class);
			previousIntent.setAction(Constants.ACTION.PREV_ACTION);
			PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
					previousIntent, 0);

			Intent playIntent = new Intent(this, PlayerService.class);
			playIntent.setAction(Constants.ACTION.PLAY_ACTION);
			PendingIntent pplayIntent = PendingIntent.getService(this, 0,
					playIntent, 0);

			Intent nextIntent = new Intent(this, PlayerService.class);
			nextIntent.setAction(Constants.ACTION.NEXT_ACTION);
			PendingIntent pnextIntent = PendingIntent.getService(this, 0,
					nextIntent, 0);

			Intent closeIntent = new Intent(this, PlayerService.class);
			closeIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
			PendingIntent pcloseIntent = PendingIntent.getService(this, 0,
					closeIntent, 0);

			views.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);
			bigViews.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);

			views.setOnClickPendingIntent(R.id.status_bar_next, pnextIntent);
			bigViews.setOnClickPendingIntent(R.id.status_bar_next, pnextIntent);

			views.setOnClickPendingIntent(R.id.status_bar_previous,
					ppreviousIntent);
			bigViews.setOnClickPendingIntent(R.id.status_bar_previous,
					ppreviousIntent);

			views.setOnClickPendingIntent(R.id.status_bar_collapse,
					pcloseIntent);
			bigViews.setOnClickPendingIntent(R.id.status_bar_collapse,
					pcloseIntent);

			views.setImageViewResource(R.id.status_bar_play,
					R.drawable.apollo_holo_dark_pause);
			bigViews.setImageViewResource(R.id.status_bar_play,
					R.drawable.apollo_holo_dark_pause);

			views.setTextViewText(R.id.status_bar_track_name, name_of_song);
			bigViews.setTextViewText(R.id.status_bar_track_name, current_name);

			bigViews.setTextViewText(R.id.status_bar_artist_name,
					current_reader);

			bigViews.setTextViewText(R.id.status_bar_album_name, "");
			status = new NotificationCompat.Builder(this).build();
			status.contentView = views;
			initbigContent();
			status.flags = Notification.FLAG_ONGOING_EVENT;
			status.icon = R.drawable.ic_launcher;
			status.contentIntent = pendingIntent;
			status.tickerText = "QuranMP3:«· ‘€Ì· «·Œ«—ÃÌ";
			startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
					status);
		} catch (Exception e) {
			Toast.makeText(this, "≈’œ«— Â« ›ﬂ ﬁœÌ„..·« Ì„ﬂ‰  ›⁄Ì· «·„Ì“… ",
					Toast.LENGTH_SHORT).show();
		}
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	private void initbigContent() {
		// TODO Auto-generated method stub
		status.bigContentView = bigViews;
	}

	void playPauseSong() {

		if (!mp2.isPlaying()) {
			try {
				mp2.reset();
				mp2.setDataSource(songsList.get(current_index).get("songPath"));
				mp2.prepare();
				mp2.start();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch bloc
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			mp2.pause();
		}

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		try {
			if (mp2 != null) {
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp2.release();
				mp2 = null;
			}
		} catch (Exception e) {

		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onInfo(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSeekComplete(MediaPlayer mp) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		try {
			if (!mp2.isPlaying()) {
				mp2.start();
			}
		} catch (Exception e) {

		}

	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		if (current_index < (songsList.size() - 1)) {
			current_index = current_index++;
			playPauseSong();
			current_index = current_index + 1;
		} else {
			// play first song
			current_index = 0;
			playPauseSong();
			current_index = 0;

		}

	}

}
