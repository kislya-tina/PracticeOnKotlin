package me.apps.personal_account_npo_mir.view.main.instruments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.main.InstrumentPresenter
import me.apps.personalaccountnpomir.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

const val ARG_OBJECT = "object"

class InstrumentFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_instrument, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = view.findViewById(R.id.meterNameTextView2)
            val dateView: TextView = view.findViewById(R.id.dateTextView)
            val indicationsTextView = view.findViewById<TextView>(R.id.meterIndicationsTextView)
            textView.text = generateMeterName()
            indicationsTextView.text = sumIndications
            dateView.text = currentDate.toString()

            archiveButton = view.findViewById(R.id.archiveButton)
            diagnosticButton = view.findViewById(R.id.diagnosticButton)
            transmittalButton = view.findViewById(R.id.transButton)
            informationButton = view.findViewById(R.id.informationButton)

            archiveButton.setOnClickListener(this@InstrumentFragment)
            diagnosticButton.setOnClickListener(this@InstrumentFragment)
            transmittalButton.setOnClickListener(this@InstrumentFragment)
            informationButton.setOnClickListener(this@InstrumentFragment)


        }
    }




    private fun generateMeterName(): String {
        return (1..10).map { Random.nextInt(1..9) }.joinToString("")
    }

    private var sumIndications:
            String = "   " + App.metersService.getLastMeasures(123, "123")["summary"].toString()


    private val simpleDate = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.GERMANY)
    private val currentDate = simpleDate.format(Date())

    private lateinit var archiveButton: Button
    private lateinit var diagnosticButton: Button
    private lateinit var transmittalButton: Button
    private lateinit var informationButton: Button

    override fun onClick(view: View?) {
        if (view === archiveButton) {
            presenter.onArchiveButtonClick()
        }
        if (view === diagnosticButton) {
            presenter.onDiagnosticButtonClick()
        }
        if (view === transmittalButton) {
            presenter.onTransmittalButtonClick()
        }
        if (view === informationButton) {
            presenter.onInformationButtonClick()
        }
    }

    private var presenter = InstrumentPresenter()
}