package com.affinity.teammotivation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.affinity.teammotivation.R;
import com.affinity.teammotivation.adapter.RelatedVideoList_Adapter;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class VideoDtlsActivity extends AppCompatActivity {

    SimpleExoPlayerView exoPlayerView;
    ImageView back;
    // creating a variable for exoplayer
    SimpleExoPlayer exoPlayer;

    // url of video which we are loading.
    String videoURL = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";

    //int[] images = {R.drawable.test_series_icon, R.drawable.studymaterial_icon, R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon,R.drawable.test_series_icon, R.drawable.studymaterial_icon, R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon, R.drawable.bank_icon,R.drawable.studymaterial_icon};
    String [] catname = {"Upper Limbs (Part - 14)\nTeam Professor" ,"Upper Limbs (Part - 15)\nTeam Professor" ,"Upper Limbs (Part - 16)\nTeam Professor" ,"Upper Limbs (Part - 17)\nTeam Professor " ,"Upper Limbs (Part - 18)\nTeam Professor","Upper Limbs (Part - 19)\nTeam Professor","Upper Limbs (Part - 20)\nTeam Professor","Upper Limbs (Part - 21)\nTeam Professor","Upper Limbs (Part - 22)\nTeam Professor","Upper Limbs (Part - 23)\nTeam Professor","Upper Limbs (Part - 24)\nTeam Professor","Upper Limbs (Part - 25)\nTeam Professor","Upper Limbs (Part - 26)\nTeam Professor","Upper Limbs (Part - 27)\nTeam Professor","Upper Limbs (Part - 28)\nTeam Professor","Upper Limbs (Part - 29)\nTeam Professor"};
    RecyclerView first_listlView;
    RelatedVideoList_Adapter first_listlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_dtls);



        first_listlView = (RecyclerView) findViewById(R.id.first_listcat);
        first_listlAdapter = new RelatedVideoList_Adapter(VideoDtlsActivity.this, catname);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);

        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exoPlayer != null) {
                    exoPlayer.setPlayWhenReady(false);
                    exoPlayer.stop();
                    exoPlayer.seekTo(0);
                }
                startActivity(new Intent(VideoDtlsActivity.this,VideoActivity.class));
                finish();
            }
        });

        exoPlayerView = findViewById(R.id.idExoPlayerVIew);
        try {

            // bandwisthmeter is used for
            // getting default bandwidth
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

            // track selector is used to navigate between
            // video using a default seekbar.
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));

            // we are adding our track selector to exoplayer.
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            // we are parsing a video url
            // and parsing its video uri.
            Uri videouri = Uri.parse(videoURL);

            // we are creating a variable for datasource factory
            // and setting its user agent as 'exoplayer_view'
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");

            // we are creating a variable for extractor factory
            // and setting it to default extractor factory.
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

            // we are creating a media source with above variables
            // and passing our event handler as null,
            MediaSource mediaSource = new ExtractorMediaSource(videouri, dataSourceFactory, extractorsFactory, null, null);

            // inside our exoplayer view
            // we are setting our player
            exoPlayerView.setPlayer(exoPlayer);

            // we are preparing our exoplayer
            // with media source.
            exoPlayer.prepare(mediaSource);

            // we are setting our exoplayer
            // when it is ready.
            exoPlayer.setPlayWhenReady(true);

        } catch (Exception e) {
            // below line is used for
            // handling our errors.
            Log.e("TAG", "Error : " + e.toString());
        }
    }

    @Override
    public void onBackPressed() {
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            exoPlayer.stop();
            exoPlayer.seekTo(0);
        }
    }
}