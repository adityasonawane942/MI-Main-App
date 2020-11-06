package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.miapp.Ham_menu.Contact_us;
import com.example.miapp.Ham_menu.Developers;
import com.example.miapp.Ham_menu.FAQ;
import com.example.miapp.Ham_menu.Helpline;
import com.example.miapp.Ham_menu.Result;
import com.example.miapp.Ham_menu.Sponsors;
import com.example.miapp.adapters.ScreenSlidePagerAdapter;
import com.example.miapp.fragment.ScreenSlidePageFragment;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    BoomMenuButton bmb, bmb2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bmb2= findViewById(R.id.bmb2);

        ArrayList<ScreenSlidePageFragment> fragList = new ArrayList<>();
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.home), R.color.red_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.search), R.color.blue_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.likes), R.color.blue_grey_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.notification), R.color.green_inactive));
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.profile), R.color.purple_inactive));
        final ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(fragList, getSupportFragmentManager());

        final BubbleNavigationLinearView bubbleNavigationLinearView = findViewById(R.id.bottom_navigation_view_linear);

//        bubbleNavigationLinearView.setBadgeValue(0, "40");
//        bubbleNavigationLinearView.setBadgeValue(1, null); //invisible badge
//        bubbleNavigationLinearView.setBadgeValue(2, "7");
//        bubbleNavigationLinearView.setBadgeValue(3, "2");
//        bubbleNavigationLinearView.setBadgeValue(4, ""); //empty badge

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        final FrameLayout layout = findViewById(R.id.frame);
        viewPager.setCurrentItem(2, true);
        bubbleNavigationLinearView.setCurrentActiveItem(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                bubbleNavigationLinearView.setCurrentActiveItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {

                layout.setVisibility(View.GONE);
                viewPager.setCurrentItem(position, true);
            }
        });



        for ( int i = 0; i < bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
            final int j=5-i;
            String s;

            switch (j) {
                case 0:
                    s = "Result";
                    break;

                case 1:
                    s = "FAQs";
                    break;

                case 2:
                    s = "Sponsors";
                    break;

                case 3:
                    s = "Helpline";
                    break;

                case 4:
                    s = "Developers";
                    break;

                case 5:
                    s = "Contact Us";
                    break;
                default:
                    s = "Contact Us";
            }
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(R.drawable.butterfly)
                    .normalText(s)
                    .subNormalText("all hail Sudhanshu Sahil, king of Pizza Maniacs")
                    .listener(new OnBMClickListener() {


                        @Override
                        public void onBoomButtonClick(int index) {
                            Fragment yourFragment;
                            // When the boom-button corresponding this builder is clicked.
                            switch (j){
                                case 0:
                                    yourFragment = new Result();
                                    break;

                                case 1:
                                    yourFragment = new FAQ();
                                    break;

                                case 2:
                                    yourFragment = new Sponsors();
                                    break;

                                case 3:
                                    yourFragment = new Helpline();
                                    break;

                                case 4:
                                    yourFragment = new Developers();
                                    break;

                                case 5:
                                    yourFragment = new Contact_us();
                                    break;
                                default:
                                    yourFragment = new Contact_us();
                            }
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            layout.setVisibility(View.VISIBLE);
                            fragmentManager.beginTransaction().replace(R.id.frame, yourFragment).commit();

                            Toast.makeText(MainActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                        }

                    });
            bmb2.addBuilder(builder);

        }




    }
}
