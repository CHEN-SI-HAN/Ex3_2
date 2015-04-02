package idv.leo.ex3_2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView textView;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationSet animationSet = getAnimationSet();
                textView.startAnimation(animationSet);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.clearAnimation();

            }
        });

    }

    private TranslateAnimation getTranslateAnimation() {
        View parentView = (View) textView.getParent();

        float distance = parentView.getWidth() - parentView.getPaddingLeft() -
                parentView.getPaddingRight() - textView.getWidth();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, distance, 0, distance);
        //效果時間
        translateAnimation.setDuration(1200);
        //播放模式 RESTART重新播放 REVERSE反向播放
        translateAnimation.setRepeatMode(Animation.RESTART);
        //播放次數
        translateAnimation.setRepeatCount(Animation.INFINITE);

        return translateAnimation;
    }

    private RotateAnimation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 0.0f, 100.0f);

        rotateAnimation.setDuration(400);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        return rotateAnimation;
    }


    private AnimationSet getAnimationSet() {
        AnimationSet animationSet = new AnimationSet(true);
//        TranslateAnimation translateAnimation = getTranslateAnimation();
//        animationSet.addAnimation(translateAnimation);
        RotateAnimation rotateAnimation = getRotateAnimation();
        animationSet.addAnimation(rotateAnimation);
        TranslateAnimation translateAnimation = getTranslateAnimation();
        animationSet.addAnimation(translateAnimation);
        return animationSet;
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
