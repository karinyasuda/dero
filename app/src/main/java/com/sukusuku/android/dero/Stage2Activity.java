//package drawable;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//
//public class Stage2Activity extends ActionBarActivity {
//
//    private boolean flag1, flag2, flag3, flag4;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_stage2);
//        /*
//		 * flag1 = false; flag2 = false; flag3 = false; flag4 = false;
//		 * を、まとめて書いているよ！
//		 */
//        flag1 = flag2 = flag3 = flag4 = false;
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.stage2, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void click1(View v) {
//		/*
//		 * uno(ウーノ:1)が最初に押されたか判定しているよ！ !flag1 っていうのは flag1 == false って意味！
//		 * ちなみに条件に flag1 って書くと flag1 == true って意味になるよ！
//		 */
//        if (!flag1 && !flag2 && !flag3 && !flag4) {
//            flag1 = true;
//        } else {
//            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
//            flag1 = flag2 = flag3 = flag4 = false;
//        }
//    }
//
//    public void click2(View v) {
//        // deux(ドゥー:2)が2番目に押されたか判定しているよ！
//        if (flag1 && !flag2 && !flag3 && !flag4) {
//            flag2 = true;
//        } else {
//            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
//            flag1 = flag2 = flag3 = flag4 = false;
//        }
//    }
//
//    public void click3(View v) {
//        // 3が3番目に押されたか判定しているよ！
//        if (flag1 && flag2 && !flag3 && !flag4) {
//            flag3 = true;
//        } else {
//            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
//            flag1 = flag2 = flag3 = flag4 = false;
//        }
//    }
//
//    public void click4(View v) {
//        // vier(フィアー:4)が4番目に押されたか判定しているよ！
//        if (flag1 && flag2 && flag3 && !flag4) {
//            flag4 = true;
//            Toast.makeText(this, "clear!!!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this,ClearActivity.class);
//            startActivity(intent);
//        } else {
//            Toast.makeText(this, "違うよ！", Toast.LENGTH_SHORT).show();
//            flag1 = flag2 = flag3 = flag4 = false;
//        }
//    }
//
//}
