package tw.tcnr12.m0501

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity

class M0501 : AppCompatActivity() {
    private var s001: Spinner? = null
    private var e001: EditText? = null
    private var b001: Button? = null
    private var t000: TextView? = null
    private var sSex: String? = null
    private val iAge = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m0501)
        setupViewcompontent()
    }

    private fun setupViewcompontent() {
        s001 = findViewById<View>(R.id.m0501_s001) as Spinner
        e001 = findViewById<View>(R.id.m0501_e001) as EditText
        b001 = findViewById<View>(R.id.m0501_b001) as Button
        t000 = findViewById<View>(R.id.m0501_t000) as TextView

//---------設定spinner item選項--------------
        val adapSexList = ArrayAdapter.createFromResource(this, R.array.m0501_a001, android.R.layout.simple_spinner_item)
        adapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) //設定跳出視窗的外觀
        s001!!.adapter = adapSexList
        s001!!.onItemSelectedListener = s001ON
        // ----------------------------------------------------------------------------------------------
        b001!!.setOnClickListener(b001ON)
    }

    private val s001ON: OnItemSelectedListener = object : OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            sSex = parent.selectedItem.toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
    private val b001ON = View.OnClickListener {
        var strSug = getString(R.string.m0501_t000)
        // 檢查 年齡是否有輸入
        if (e001!!.text.toString().trim { it <= ' ' }.length != 0) {
            val iAge = e001!!.text.toString().toInt()
            strSug += if (sSex == getString(R.string.chkSex)) if (iAge < 28) getString(R.string.m0501_f001) else if (iAge > 33) getString(R.string.m0501_f003) else {
                getString(R.string.m0501_f002)
            } else if (iAge < 25) getString(R.string.m0501_f001) else if (iAge > 30) getString(R.string.m0501_f003) else {
                getString(R.string.m0501_f002)
            }
            t000!!.text = strSug
            //-------------------------------------------------------
        } else {
            strSug = getString(R.string.nospace) //else { //年齡輸入空白
        }
        t000!!.text = strSug //請勿輸入空白
    }
}
//package tw.tcnr12.m0501
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class M0501 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.m0501)
//    }
//}