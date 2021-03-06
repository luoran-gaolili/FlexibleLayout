package view.gavin.com.flexibleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gavin.view.flexible.FlexibleLayout;
import com.gavin.view.flexible.callback.OnReadyPullListener;

import java.util.ArrayList;
import java.util.List;

import view.gavin.com.flexibleview.adapter.SimpleListAdapter;

/**
 * Created by gavin
 * date 2018/6/18
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        View header = findViewById(R.id.iv);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item : " + i);
        }
        SimpleListAdapter adapter = new SimpleListAdapter(this, list);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        FlexibleLayout flexibleLayout = (FlexibleLayout) findViewById(R.id.fv);
        flexibleLayout.setReadyListener(new OnReadyPullListener() {
            @Override
            public boolean isReady() {
                return manager.findFirstCompletelyVisibleItemPosition() == 0;
            }
        });
        flexibleLayout.setHeader(header);
    }
}
