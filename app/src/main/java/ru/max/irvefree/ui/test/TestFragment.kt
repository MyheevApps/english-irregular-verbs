package ru.max.irvefree.ui.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.max.irvefree.R

class TestFragment : Fragment() {

    private lateinit var btnElementary: Button
    private lateinit var btnPreIntermediate: Button
    private lateinit var btnIntermediate: Button
    private lateinit var btnUpperIntermediate: Button
    private lateinit var btnAdvanced: Button
    private lateinit var btnProficiency: Button
    private lateinit var btnMarathon: Button
    private val levelKey: String = "LEVEL_KEY"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnElementary = view.findViewById(R.id.btn_elementary)
        btnPreIntermediate = view.findViewById(R.id.btn_pre_intermediate)
        btnIntermediate = view.findViewById(R.id.btn_intermediate)
        btnUpperIntermediate = view.findViewById(R.id.btn_upper_intermediate)
        btnAdvanced = view.findViewById(R.id.btn_advanced)
        btnProficiency = view.findViewById(R.id.btn_proficiency)
        btnMarathon = view.findViewById(R.id.btn_marathon)

        btnElementary.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.elementary)))
        }

        btnPreIntermediate.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.pre_inter)))
        }

        btnIntermediate.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.intermediate)))
        }

        btnUpperIntermediate.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.upper_inter)))
        }

        btnAdvanced.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.advanced)))
        }

        btnProficiency.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.proficiency)))
        }

        btnMarathon.setOnClickListener {
            startActivity(Intent(activity, PageTestActivity::class.java)
                .putExtra(levelKey, getString(R.string.marathon)))
        }
    }
}