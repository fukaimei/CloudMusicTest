package net.fkm.cloudmusictest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.fkm.cloudmusictest.R;
import net.fkm.cloudmusictest.adapter.MusicAdapter;
import net.fkm.cloudmusictest.model.MusicModel;
import net.fkm.cloudmusictest.utils.CheckNetwork;
import net.fkm.cloudmusictest.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_music)
    RecyclerView rvMusic;

    private MusicAdapter adapter;
    private List<MusicModel> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);

        // 模拟从网络获取音乐数据列表
        for (int i = 0; i < 10; i++) {

            MusicModel musicModel = new MusicModel();
            musicModel.setName("理想三旬");
            musicModel.setAuthor("陈鸿宇");
            musicModel.setMusicId("123456");
            musicModel.setPoster("https://img1.doubanio.com/view/subject/m/public/s29719507.jpg");
            musicModel.setRemark("旅途中的追逐");
            musicModel.setPath("http://res.lgdsunday.club/Nostalgic%20Piano.mp3");
            mList.add(musicModel);

            MusicModel musicModel1 = new MusicModel();
            musicModel1.setName("一如年少模样");
            musicModel1.setAuthor("陈鸿宇");
            musicModel1.setMusicId("654321");
            musicModel1.setPoster("https://img1.doubanio.com/view/subject/m/public/s29361389.jpg");
            musicModel1.setRemark("三旬尚远浓烟散 一如年少迟夏归");
            musicModel1.setPath("http://res.lgdsunday.club/Nostalgic%20Piano.mp3");
            mList.add(musicModel1);

        }

        rvMusic.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new MusicAdapter(this, mList);
        rvMusic.setAdapter(adapter);

        adapter.setItemClikListener(new MusicAdapter.OnItemClikListener() {
            @Override
            public void onItemClik(View view, int position) {
                if (!CheckNetwork.isNetworkConnected(MainActivity.this)) {
                    ToastUtil.showToastLong("当前网络不可用，请检查您的网络设置");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, PlayMusicActivity.class);
                intent.putExtra(PlayMusicActivity.NAME, mList.get(position).getName());
                intent.putExtra(PlayMusicActivity.POSTER, mList.get(position).getPoster());
                intent.putExtra(PlayMusicActivity.PATH, mList.get(position).getPath());
                intent.putExtra(PlayMusicActivity.AUTHOR, mList.get(position).getAuthor());
                startActivity(intent);
            }

            @Override
            public void onItemLongClik(View view, int position) {

            }
        });

    }

}
