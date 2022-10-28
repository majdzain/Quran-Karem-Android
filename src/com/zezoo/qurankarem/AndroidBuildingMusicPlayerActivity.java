package com.zezoo.qurankarem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidBuildingMusicPlayerActivity extends Activity
		implements OnCompletionListener, SeekBar.OnSeekBarChangeListener, OnErrorListener {
	// DownloadManager
	DownloadManager downloadManager;
	// ImageButton
	ImageButton btnPlay, btnForward, btnBackward, btnNext, btnPrevious, btnPlaylist, btnDownload, btnRepeat, btnShuffle;
	// SeekBar
	SeekBar songProgressBar;
	// TextView
	TextView songTitleLabel, songCurrentDurationLabel, songTotalDurationLabel, readerTitleLabel;
	// MediaPlayer
	MediaPlayer mp;
	// Handler
	Handler mHandler = new Handler();
	// Utilities
	Utilities utils;
	// SharedPreferences
	SharedPreferences prefs3, prefs4;
	// List_Activity
	List_Activity l_a = new List_Activity();
	// ArrayList
	ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	// Context
	Context context = AndroidBuildingMusicPlayerActivity.this;
	// int
	int seekForwardTime = 5000, seekBackwardTime = 5000, currentSongIndex = 0, current_reader1 = 0;
	// boolean
	boolean isShuffle = false, isRepeat = false, areExist, isOne;
	// long
	long totalDuration, currentDuration;
	// String
	private static final String SeekFile = "seek_file";
	private BroadcastReceiver receveirDownloadComplete;
	// StringArray
	String ifs_song[] = { "”Ê—… «·›« Õ…", "”Ê—… «·»ﬁ—…", "”Ê—… ¬· ⁄„—«‰", "”Ê—… «·‰”«¡", "”Ê—… «·„«∆œ…", "”Ê—… «·√‰⁄«„",
			"”Ê—… «·√⁄—«›", "”Ê—… «·√‰›«·", "”Ê—… «· Ê»…", "”Ê—… ÌÊ‰”", "”Ê—… ÂÊœ", "”Ê—… ÌÊ”›", "”Ê—… «·—⁄œ",
			"”Ê—… ≈»—«ÂÌ„", "”Ê—… «·ÕÃ—", "”Ê—… «·‰Õ·", "”Ê—… «·≈”—«¡", "”Ê—… «·ﬂÂ›", "”Ê—… „—Ì„", "”Ê—… ÿÂ",
			"”Ê—… «·√‰»Ì«¡", "”Ê—… «·ÕÃ", "”Ê—… «·„ƒ„‰Ê‰", "”Ê—… «·‰Ê—", "”Ê—… «·›—ﬁ«‰", "”Ê—… «·‘⁄—«¡", "”Ê—… «·‰„·",
			"”Ê—… «·ﬁ’’", "”Ê—… «·⁄‰ﬂ»Ê ", "”Ê—… «·—Ê„", "”Ê—… ·ﬁ„«‰", "”Ê—… «·”Ãœ…", "”Ê—… «·√Õ“«»", "”Ê—… ”»√",
			"”Ê—… ›«ÿ—", "”Ê—… Ì”", "”Ê—… «·’«›« ", "”Ê—… ’", "”Ê—… «·“„—", "”Ê—… €«›—", "”Ê—… ›’· ", "”Ê—… «·‘Ê—Ï",
			"”Ê—… «·“Œ—›", "”Ê—… «·œŒ«‰", "”Ê—… «·Ã«ÀÌ…", "”Ê—… «·√Õﬁ«›", "”Ê—… „Õ„œ", "”Ê—… «·› Õ", "”Ê—… «·ÕÃ—« ",
			"”Ê—… ﬁ", "”Ê—… «·–«—Ì« ", "”Ê—… «·ÿÊ—", "”Ê—… «·‰Ã„", "”Ê—… «·ﬁ„—", "”Ê—… «·—Õ„‰", "”Ê—… «·Ê«ﬁ⁄…",
			"”Ê—… «·ÕœÌœ", "”Ê—… «·„Ã«œ·…", "”Ê—… «·Õ‘—", "”Ê—… «·„„ Õ‰…", "”Ê—… «·’›", "”Ê—… «·Ã„⁄…", "”Ê—… «·„‰«›ﬁÊ‰",
			"”Ê—… «· €«»‰", "”Ê—… «·ÿ·«ﬁ", "”Ê—… «· Õ—Ì„", "”Ê—… «·„·ﬂ", "”Ê—… «·ﬁ·„", "”Ê—… «·Õ«ﬁ…", "”Ê—… «·„⁄«—Ã",
			"”Ê—… ‰ÊÕ", "”Ê—… «·Ã‰", "”Ê—… «·„“„·", "”Ê—… «·„œÀ—", "”Ê—… «·ﬁÌ«„…", "”Ê—… «·≈‰”«‰", "”Ê—… «·„—”·« ",
			"”Ê—… «·‰»√", "”Ê—… «·‰«“⁄« ", "”Ê—… ⁄»”", "”Ê—… «· ﬂÊÌ—", "”Ê—… «·«‰›ÿ«—", "”Ê—… «·„ÿ››Ì‰",
			"”Ê—… «·«‰‘ﬁ«ﬁ", "”Ê—… «·»—ÊÃ", "”Ê—… «·ÿ«—ﬁ", "”Ê—… «·√⁄·Ï", "”Ê—… «·€«‘Ì…", "”Ê—… «·›Ã—", "”Ê—… «·»·œ",
			"”Ê—… «·‘„”", "”Ê—… «··Ì·", "”Ê—… «·÷ÕÏ", "”Ê—… «·‘—Õ", "”Ê—… «· Ì‰", "”Ê—… «·⁄·ﬁ", "”Ê—… «·ﬁœ—",
			"”Ê—… «·»Ì‰…", "”Ê—… «·“·“·…", "”Ê—… «·⁄«œÌ« ", "”Ê—… «·ﬁ«—⁄…", "”Ê—… «· ﬂ«À—", "”Ê—… «·⁄’—", "”Ê—… «·Â„“…",
			"”Ê—… «·›Ì·", "”Ê—… ﬁ—Ì‘", "”Ê—… «·„«⁄Ê‰", "”Ê—… «·ﬂÊÀ—", "”Ê—… «·ﬂ«›—Ê‰", "”Ê—… «·‰’—", "”Ê—… «·„”œ",
			"”Ê—… «·≈Œ·«’", "”Ê—… «·›·ﬁ", "”Ê—… «·‰«”" };
	String ifs_reader[] = { "”⁄œ «·€«„œÌ", "⁄»œ «·»«”ÿ ⁄»œ «·’„œ", "„‘«—Ì »‰ —«‘œ «·⁄›«”Ì", "”⁄Êœ «·‘—Ì„",
			"„Õ„Êœ Œ·Ì· «·Õ’—Ì", "„Õ„œ ’œÌﬁ «·„‰‘«ÊÌ", "⁄·Ì Ã«»—", "⁄·Ì «·Õ–Ì›Ì" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		setFilePathes();
		setVaribals();
		setMore();
		setListeners();
	}

	private void setFilePathes() {
		// setPathes
		File folder0 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/saad-el-ghamidi");
		if (!folder0.exists()) {
			folder0.mkdirs();
		}
		File folder1 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/abdel-basset");
		if (!folder1.exists()) {
			folder1.mkdirs();
		}
		File folder2 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/mishary-rashid-alafasy");
		if (!folder2.exists()) {
			folder2.mkdirs();
		}
		File folder3 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/saud-shuraim");
		if (!folder3.exists()) {
			folder3.mkdirs();
		}
		File folder4 = new File(
				Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/mahmoud-khalil-al-hussary");
		if (!folder4.exists()) {
			folder4.mkdirs();
		}
		File folder5 = new File(
				Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/mohamed-seddik-el-menchaoui");
		if (!folder5.exists()) {
			folder5.mkdirs();
		}
		File folder6 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/ali-jaber");
		if (!folder6.exists()) {
			folder6.mkdirs();
		}
		File folder7 = new File(Environment.getExternalStorageDirectory() + "/QuranKarem/Souar/ali-al-hodhaifi");
		if (!folder7.exists()) {
			folder7.mkdirs();
		}
		if (folder0.isDirectory() && folder1.isDirectory() && folder2.isDirectory() && folder3.isDirectory()
				&& folder4.isDirectory() && folder5.isDirectory() && folder6.isDirectory() && folder7.isDirectory()) {
			File[] files = folder0.listFiles();
			File[] files1 = folder1.listFiles();
			File[] files2 = folder2.listFiles();
			File[] files3 = folder3.listFiles();
			File[] files4 = folder4.listFiles();
			File[] files5 = folder5.listFiles();
			File[] files6 = folder6.listFiles();
			File[] files7 = folder7.listFiles();
			if (files.length == 0 && files1.length == 0 && files2.length == 0 && files3.length == 0
					&& files4.length == 0 && files5.length == 0 && files6.length == 0 && files7.length == 0) {
				areExist = false;
				isOne = false;
			} else if (files.length == 1 && files1.length == 0 && files2.length == 0 && files3.length == 0
					&& files4.length == 0 && files5.length == 0 && files6.length == 0 && files7.length == 0) {
				areExist = true;
				isOne = true;
			} else {
				areExist = true;
			}
		} else {
			areExist = false;
			isOne = false;
		}
		if (!areExist) {

		}

	}

	private void setVaribals() {
		btnPlay = (ImageButton) findViewById(R.id.btnPlay);
		btnForward = (ImageButton) findViewById(R.id.btnForward);
		btnBackward = (ImageButton) findViewById(R.id.btnBackward);
		btnNext = (ImageButton) findViewById(R.id.btnNext);
		btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
		btnPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);
		btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
		btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
		btnDownload = (ImageButton) findViewById(R.id.btnDownload);
		songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
		songTitleLabel = (TextView) findViewById(R.id.songTitle);
		songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
		songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);
		readerTitleLabel = (TextView) findViewById(R.id.readerTitle);
		mp = new MediaPlayer();
		utils = new Utilities();
		downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		prefs3 = getSharedPreferences("reader_file", MODE_PRIVATE);
		prefs4 = getSharedPreferences(SeekFile, MODE_PRIVATE);
		current_reader1 = prefs3.getInt("reader_key", 0);
	}

	private void setMore() {
		readerTitleLabel.setText(ifs_reader[current_reader1]);
		songProgressBar.setOnSeekBarChangeListener(this);
		mp.setOnCompletionListener(this);
		if (areExist) {
			playSong(0);
		} else {
			receveirDownloadComplete = new BroadcastReceiver() {

				@Override
				public void onReceive(Context context, Intent intent) {
					String action = intent.getAction();
					if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
						setFilePathes();
						playSong(0);
					}

				}
			};
			registerReceiver(receveirDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
			AlertDialog alertDialog = new AlertDialog.Builder(AndroidBuildingMusicPlayerActivity.this).create();
			alertDialog.setTitle(" Õ–Ì—...");
			alertDialog.setMessage("”Ì „  Õ„Ì· ”Ê—… «·›« Õ… „»œ√Ì« „‰ «·√‰ —‰  · ‘€Ì· «·»—‰«„Ãø");
			alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "„Ê«›ﬁ", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					DownloadManager.Request request1 = new DownloadManager.Request(
							Uri.parse("http://ia800305.us.archive.org/24/items/TvQuran.com__Al-Ghamdi/001.mp3"));
					request1.setTitle("”Ê—… «·›« Õ…" + "-" + "”⁄œ «·€«„œÌ")
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3").setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir("/QuranKarem/Souar/saad-el-ghamidi",
									"1- ”Ê—… «·›« Õ…" + ".mp3");
					downloadManager.enqueue(request1);
				}
			});
			alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "≈·€«¡", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			alertDialog.show();
		}

	}

	private void setListeners() {
		btnDownload.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mp.isPlaying()) {
					if (mp != null) {
						mp.pause();
						btnPlay.setImageResource(R.drawable.btn_play);
					}
				}

				Intent i = new Intent(AndroidBuildingMusicPlayerActivity.this, DownloadActivity.class);
				startActivity(i);

			}
		});
		btnPlay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (areExist) {
					if (mp.isPlaying()) {
						if (mp != null) {
							mp.pause();
							btnPlay.setImageResource(R.drawable.btn_play);
						}
					} else {
						if (mp != null) {
							mp.start();
							btnPlay.setImageResource(R.drawable.btn_pause);
						}
					}
				} else {
					btnPlay.setImageResource(R.drawable.btn_play);
					Toast.makeText(getApplicationContext(), "ÌÃ»  Õ„Ì· ”Ê—… Ê«Õœ… ⁄·Ï «·√ﬁ·", 1500).show();
				}

			}
		});
		btnForward.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (areExist) {
					int currentPosition = mp.getCurrentPosition();
					if (currentPosition + seekForwardTime <= mp.getDuration()) {
						mp.seekTo(currentPosition + seekForwardTime);
					} else {
						mp.seekTo(mp.getDuration());
					}
				} else {

				}
			}
		});
		btnBackward.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (areExist) {
					int currentPosition = mp.getCurrentPosition();
					if (currentPosition - seekBackwardTime >= 0) {
						mp.seekTo(currentPosition - seekBackwardTime);
					} else {
						mp.seekTo(0);
					}
				} else {

				}
			}
		});
		btnNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (areExist) {
					if (currentSongIndex < (songsList.size() - 1)) {
						playSong(currentSongIndex + 1);
						currentSongIndex = currentSongIndex + 1;
					} else {
						playSong(0);
						currentSongIndex = 0;
					}
				} else {
					Toast.makeText(getApplicationContext(), "·« ÌÊÃœ ”Ê—… √Œ—Ï ·› ÕÂ« ,Ì—ÃÏ  Õ„Ì· «·”Ê— „‰ «·√⁄œ«œ« ",
							2000).show();
				}
			}
		});
		btnPrevious.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (areExist) {
					if (isOne) {
						playSong(0);
					} else {
						if (currentSongIndex > 0) {
							playSong(currentSongIndex - 1);
							currentSongIndex = currentSongIndex - 1;
						} else {
							playSong(songsList.size() - 1);
							currentSongIndex = songsList.size() - 1;
						}
					}
				} else {
					Toast.makeText(getApplicationContext(), "·« ÌÊÃœ ”Ê—… √Œ—Ï ·› ÕÂ« ,Ì—ÃÏ  Õ„Ì· «·”Ê— „‰ «·√⁄œ«œ« ",
							2000).show();
				}
			}
		});
		btnRepeat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isRepeat) {
					isRepeat = false;
					Toast.makeText(getApplicationContext(), "«· ﬂ—«— „€·ﬁ", Toast.LENGTH_SHORT).show();
					btnRepeat.setImageResource(R.drawable.btn_repeat);
				} else {
					isRepeat = true;
					Toast.makeText(getApplicationContext(), "«· ﬂ—«— Ì⁄„·", Toast.LENGTH_SHORT).show();
					isShuffle = false;
					btnRepeat.setImageResource(R.drawable.btn_repeat_focused);
					btnShuffle.setImageResource(R.drawable.btn_shuffle);
				}
			}
		});
		btnShuffle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (isShuffle) {
					isShuffle = false;
					Toast.makeText(getApplicationContext(), "«·Œ·ÿ „€·ﬁ", Toast.LENGTH_SHORT).show();
					btnShuffle.setImageResource(R.drawable.btn_shuffle);
				} else {
					isShuffle = true;
					Toast.makeText(getApplicationContext(), "«·Œ·ÿ Ì⁄„·", Toast.LENGTH_SHORT).show();
					isRepeat = false;
					btnShuffle.setImageResource(R.drawable.btn_shuffle_focused);
					btnRepeat.setImageResource(R.drawable.btn_repeat);
				}
			}
		});
		btnPlaylist.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mp.isPlaying()) {
					if (mp != null) {
						mp.pause();
						btnPlay.setImageResource(R.drawable.btn_play);
					}
				}

				Intent i = new Intent(getApplicationContext(), List_Activity.class);
				startActivityForResult(i, 100);
			}
		});

	}

	/**
	 * Receiving song index from playlist view and play the song
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 100) {
			currentSongIndex = data.getExtras().getInt("songIndex");
			// play selected song
			playSong(currentSongIndex);
		}

	}

	/**
	 * Function to play a song
	 * 
	 * @param songIndex
	 *            - index of song
	 */
	public void playSong(int songIndex) {
		// Play song
		try {
			mp.reset();
			mp.setDataSource("/mnt/sdcard/qurankarem/Souar/saad-el-ghamidi/" + l_a.ifs_name[0] + ".mp3");
			mp.prepare();
			mp.start();
			// Displaying Song title
			String songTitle = ifs_song[songIndex];
			readerTitleLabel.setText(ifs_reader[current_reader1]);
			songTitleLabel.setText(songTitle);

			// Changing Button Image to pause image
			btnPlay.setImageResource(R.drawable.btn_pause);

			// set Progress bar values
			songProgressBar.setProgress(0);
			songProgressBar.setMax(100);

			// Updating progress bar
			updateProgressBar();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update timer on seekbar
	 */
	public void updateProgressBar() {
		mHandler.postDelayed(mUpdateTimeTask, 100);
	}

	/**
	 * Background Runnable thread
	 */
	private Runnable mUpdateTimeTask = new Runnable() {
		public void run() {
			if (areExist) {
				try {
					totalDuration = mp.getDuration();
					currentDuration = mp.getCurrentPosition();
				} catch (Exception e) {

				}
			} else {
				try {

				} catch (Exception e) {

				}
			}
			// Displaying Total Duration time
			songTotalDurationLabel.setText("" + utils.milliSecondsToTimer(totalDuration));
			// Displaying time completed playing
			songCurrentDurationLabel.setText("" + utils.milliSecondsToTimer(currentDuration));

			// Updating progress bar
			int progress = (int) (utils.getProgressPercentage(currentDuration, totalDuration));
			// Log.d("Progress", ""+progress);
			songProgressBar.setProgress(progress);

			// Running this thread after 100 milliseconds
			mHandler.postDelayed(this, 100);
		}
	};

	/**
	 * 
	 * */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {

	}

	/**
	 * When user starts moving the progress handler
	 */
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// remove message Handler from updating progress bar
		mHandler.removeCallbacks(mUpdateTimeTask);
	}

	/**
	 * When user stops moving the progress hanlder
	 */
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

		if (areExist) {
			try {
				mHandler.removeCallbacks(mUpdateTimeTask);
				int totalDuration = mp.getDuration();
				int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);
				// forward or backward to certain seconds
				mp.seekTo(currentPosition);
			} catch (Exception e) {

			}
		} else {
			try {

			} catch (Exception e) {

			}
		}
		// update timer progress again
		updateProgressBar();
	}

	/**
	 * On Song Playing completed if repeat is ON play same song again if shuffle
	 * is ON play random song
	 */
	@Override
	public void onCompletion(MediaPlayer arg0) {
		if (areExist) {
			// check for repeat is ON or OFF
			if (isRepeat) {
				// repeat is on play same song again
				playSong(currentSongIndex);
			} else if (isShuffle) {
				// shuffle is on - play a random song
				if (isOne) {
                    playSong(0);
				} else {
					currentSongIndex = currentSongIndex + 1;
					playSong(currentSongIndex);
				}
			} else {
				// no repeat or shuffle ON - play next song
				if (currentSongIndex < (songsList.size() - 1)) {
					playSong(currentSongIndex + 1);
					currentSongIndex = currentSongIndex + 1;
				} else {
					// play first song
					playSong(0);
					currentSongIndex = 0;

				}
			}
		} else {
			// check for repeat is ON or OFF
			if (isRepeat) {
				// repeat is on play same song again
				playSong(currentSongIndex);
			} else if (isShuffle) {
				// shuffle is on - play a random song
				playSong(currentSongIndex);
			} else {
				// no repeat or shuffle ON - play next song
				if (currentSongIndex < (songsList.size() - 1)) {
					playSong(currentSongIndex + 1);
					currentSongIndex = currentSongIndex + 1;
				} else {
					// play first song
					playSong(0);
					currentSongIndex = 0;

				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.download, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.download:
			Intent i = new Intent(AndroidBuildingMusicPlayerActivity.this, DownloadActivity.class);
			startActivity(i);
			break;
		case R.id.close:
			finish();
			break;
		}
		return false;
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		if (mp != null) {
			if (mp.isPlaying()) {
				mp.stop();
			}
			mp.release();
			mp = null;
		}

	}

	@Override
	public void onBackPressed() {

		super.onBackPressed();
		finish();
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		return false;
	}

}