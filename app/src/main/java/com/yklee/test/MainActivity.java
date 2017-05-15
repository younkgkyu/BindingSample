package com.yklee.test;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yklee.test.activity.ListBindingActivity;
import com.yklee.test.data.UserData;
import com.yklee.test.databinding.ActivityMainBinding;
import com.yklee.test.presenter.MovePresenter;

public class MainActivity extends AppCompatActivity {

    private MovePresenter mMovePresenter = new MovePresenter() {
        @Override
        public void MoveListBindingActivity(UserData userData) {
            Intent intent = new Intent(MainActivity.this, ListBindingActivity.class);
            intent.putExtra("userData", userData);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding databinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserData user = new UserData("yklee", 20);
        databinding.subView.setUser(user);
        databinding.subView.setPresenter(mMovePresenter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
