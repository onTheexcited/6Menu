package cn.edu.bistu.cs.se.a6menu;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity  implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=(TextView)findViewById(R.id.textview);
        registerForContextMenu(textView);//为界面元素使用registerForContextMenu()注册上下文菜单，注册的含义是指当在该界面元素长按时弹出上下文菜单

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_content,menu);
    }//当注册后的界面元素收到长按事件时，系统将调用 onCreateContextMenu() 方法创建菜单



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }//Activity在创建时调用 初始化自身的菜单系统

public void showPopup(View v){
    PopupMenu popub=new PopupMenu(this,v);
    popub.setOnMenuItemClickListener(this);
    popub.inflate(R.menu.menu_popub);
    popub.show();
}//用户点击时启用

@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
        case R.id.action_settings:
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_another:
            Toast.makeText(this, "another", Toast.LENGTH_SHORT).show();
            break;
    }//在选择菜单项后，处理菜单选择事件

    return super.onOptionsItemSelected(item);

}

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_another:
                Toast.makeText(this, "another", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public boolean onMenuItemClick(MenuItem menuItem) {
    switch (menuItem.getItemId()) {
        case R.id.action_settings:
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            break;
        case R.id.menu_another:
            Toast.makeText(this, "another", Toast.LENGTH_SHORT).show();
            break;
    }
    return false;
}
    }


