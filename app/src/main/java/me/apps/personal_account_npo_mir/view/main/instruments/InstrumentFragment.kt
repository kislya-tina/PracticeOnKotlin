package me.apps.personal_account_npo_mir.view.main.instruments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.main.instruments.InstrumentFragmentPresenter
import me.apps.personalaccountnpomir.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

const val ARG_OBJECT = "object"

class InstrumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instrument, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter.onViewCreated(this)

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val meterName: TextView = view.findViewById(R.id.meterNameTextView2)
            val dateView: TextView = view.findViewById(R.id.dateTextView)
            try {
                val meterIndex = this.getInt(ARG_OBJECT)
                val meterID = App.metersService.meters[meterIndex].id
                App.measuresService.getLastMeasure(
                    meterID.toInt(),
                    App.userDataService.token,
                    presenter
                )
            }
            catch (e: Exception){
                e.printStackTrace()
            }
            meterName.text = presenter.name
            dateView.text = currentDate.toString()
        }
    }

    fun setMeterIndications(){
        val indicationsTextView = view?.findViewById<TextView>(R.id.meterIndicationsTextView)
        sumIndications = App.measuresService.measure?.summary.toString()
        indicationsTextView?.text = sumIndications
    }

    private val simpleDate = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.CHINA)

    private val currentDate = simpleDate.format(Date())
    //    private var meterID = App.metersService.id
    private val presenter = InstrumentFragmentPresenter()
    private var sumIndications :
            String = ""

}