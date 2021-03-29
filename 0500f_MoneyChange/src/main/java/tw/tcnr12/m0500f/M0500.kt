//package tw.tcnr12.m0500f
package tw.tcnr12.m0500f

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

//import androidx.appcompat.app.AppCompatActivity;
class M0500 : AppCompatActivity() {
//    private var b001: Button?= null;
//    private var e001: EditText? = null;

    //Activity活動
    private var e001: EditText? = null
    private var b001: Button? = null
    private var t003: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {  //Bundle打包
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m0500)
        setupViewcomponent()
    }
//
//    private fun setupViewcomponent() {
//     e001 = findViewById<EditText>(R.id.m0500_e001) as EditText
//        b001 = findViewById<Button>(R.id.m0500_b001)
//        val a = 0
//
//
//    }

    private fun setupViewcomponent() {
//        設定layout配置
//        以下三個要設定field
//        針對變數去做宣告
        e001 = findViewById<View>(R.id.m0500_e001) as EditText //公斤kg 輸入的欄位變數名稱
        b001 = findViewById<View>(R.id.m0500_b001) as Button //執行按鈕變數名稱
        t003 = findViewById<View>(R.id.m0500_t003) as TextView //磅lb 欄位變數名稱
        b001!!.setOnClickListener(b001ON) //宣告按鈕的監聽程式
    }

    private val b001ON = View.OnClickListener {
        val pondsFormat = DecimalFormat("0.0000")
        val outcomp = pondsFormat.format(e001!!.text.toString().toFloat() * 28.6)
        t003!!.text = outcomp
    } //    @Override



    //    protected void onCreate(Bundle savedInstanceState) {
    //        super.onCreate(savedInstanceState);
    //        setContentView(R.layout.m0500);
    //    }
}
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class M0500 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.m0500)
//    }
//}