package me.apps.personalaccountnpomir.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import me.apps.personalaccountnpomir.InstrumentActivity
import me.apps.personalaccountnpomir.LogRegActivity
import me.apps.personalaccountnpomir.R
import me.apps.personalaccountnpomir.interfaces.OnFragmentLogDataListener
import org.w3c.dom.Text

class LogInFragment : Fragment() {

    private var regButton : Button? = null
    private var logButton : Button? = null
    private var idText : TextView? = null
    private var passText : TextView? = null

    private var mListener : OnFragmentLogDataListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view : View? = inflater.inflate(R.layout.fragment_log_in, container, false)

        regButton = view?.findViewById(R.id.regButt)

        regButton?.setOnClickListener(){
            fun onClick(view: View){
                mListener?.onOpenFragment2()
            }
        }

        logButton = view?.findViewById(R.id.logButt)
        idText = view?.findViewById(R.id.idText)
        passText = view?.findViewById(R.id.passText)

        logButton?.setOnClickListener(){
            if(idText?.text?.toString()?.trim()?.equals("")!! || passText?.text?.toString()?.trim()?.equals("")!!){
                Toast.makeText(activity, "Please enter ID and/or password", Toast.LENGTH_LONG).show()
            }else{
                /**
                 * todo для рамазана
                 * isLogged(id, pass)
                 *
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
                val name: String = idText?.text.toString()
                val password: String = passText?.text.toString()
                if(name != "0001" || password !="0000"){
                    Toast.makeText(activity, "Incorrect ID and/or password", Toast.LENGTH_LONG).show()
                }else {
                    var intent = Intent(activity, InstrumentActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) : LogInFragment {
            return LogInFragment()
        }
    }
}