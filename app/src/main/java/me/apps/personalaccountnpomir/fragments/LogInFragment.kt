package me.apps.personalaccountnpomir.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import me.apps.personalaccountnpomir.Back
import me.apps.personalaccountnpomir.InstrumentActivity
import me.apps.personalaccountnpomir.R
import me.apps.personalaccountnpomir.interfaces.OnFragmentLogDataListener

class LogInFragment : Fragment(),View.OnClickListener {

    private var regButton : AppCompatButton? = null
    private var logButton : Button? = null
    private var idText : TextView? = null
    private var passText : TextView? = null
    private var fm : FragmentManager? = null
    private var frag : Fragment? = null

    private var mListener : OnFragmentLogDataListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        regButton = view.findViewById(R.id.regButt)

        regButton?.setOnClickListener(this)

        logButton = view.findViewWithTag(R.id.logButt)
        idText = view.findViewWithTag(R.id.textLogin)
        passText = view.findViewWithTag(R.id.textPassword)
        frag = fm?.findFragmentById(R.id.fragmentLogContainer)
        //byTag
        //todo complete all

        logButton?.setOnClickListener(){
            if(idText?.text?.toString()?.trim()?.equals("")!! || passText?.text?.toString()?.trim()?.equals("")!!){
                Toast.makeText(activity, "Please enter ID and/or password", Toast.LENGTH_LONG).show()
            }else{
                /**
                 * todo для рамазана
                 * isLogged(id, pass)
                 * login //
                 * @param id String
                 * @param password String
                 * @return String
                 * если неверный id/password return "0" {или null}
                 * иначе return token
                 */
/*                  if(isLogged(idText?.text.toString(), passText?.text.toString()).equals("0")){
                    Toast.makeText(activity, "Incorrect ID and/or password", Toast.LENGTH_LONG).show()
                }else{
                    var intent = Intent(activity, InstrumentActivity::class.java)
                    startActivity(intent)
                }
 */
                if(Back().logIn(idText?.text.toString(), passText?.text.toString()) == "error"){
                    Toast.makeText(activity, "Incorrect ID and/or password", Toast.LENGTH_LONG).show()
                }else {
                    val intent = Intent(activity, InstrumentActivity::class.java)
                    startActivity(intent)
                    //
                }
            }
        }
    }
    override fun onDestroy() {
        //очистка ресурсов
        super.onDestroy()
        regButton?.setOnClickListener(null);
    }
    //жизненные циклы активити и фрагментов
    companion object {//todo
        @JvmStatic
        fun newInstance(param1: String, param2: String) : LogInFragment {
            return LogInFragment()
        }
    }

    override fun onClick(p0: View?) {
            mListener?.onOpenFragment2()
            //todo
            //replace
            //или таб придумать сделать
    }
}