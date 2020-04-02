package net.fkm.cloudmusictest.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import net.fkm.cloudmusictest.R;
import net.fkm.cloudmusictest.model.MusicModel;
import net.fkm.cloudmusictest.view.PlayMusicView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String POSTER = "poster";
    public static final String PATH = "path";
    public static final String AUTHOR = "author";

    private String mName;
    private String mPoster;
    private String mPath;
    private String mAuthor;
    private MusicModel mMusicModel;

    @BindView(R.id.iv_bg)
    ImageView mIvBg;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.play_music_view)
    PlayMusicView mPlayMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);

        mName = getIntent().getStringExtra(NAME);
        mPoster = getIntent().getStringExtra(POSTER);
        mPath = getIntent().getStringExtra(PATH);
        mAuthor = getIntent().getStringExtra(AUTHOR);

        mMusicModel = new MusicModel();
        mMusicModel.setName(mName);
        mMusicModel.setPath(mPath);
        mMusicModel.setPoster(mPoster);
        mMusicModel.setAuthor(mAuthor);

        Glide.with(this)
                .load(mMusicModel.getPoster())
                // 设置音乐播放器背景图片的高斯模糊度
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 35)))
                .into(mIvBg);
        mTvName.setText(mMusicModel.getName());
        mTvAuthor.setText(mMusicModel.getAuthor());

        mPlayMusicView.setMusic(mMusicModel);
        mPlayMusicView.playMusic();
    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View view) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayMusicView.destroy();
    }

}
