package com.example.androidtestnutapos.ui.daftaruangmasuk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtestnutapos.R
import com.example.androidtestnutapos.ui.AdmissionFeeAdapter
import com.example.androidtestnutapos.databinding.FragmentDaftarUangMasukBinding
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.ui.inputuangmasuk.InputUangMasukFragment
import com.google.android.material.datepicker.MaterialDatePicker

import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@AndroidEntryPoint
class DaftarUangMasukFragment : Fragment() {

    private lateinit var admissionFeeAdapter: AdmissionFeeAdapter

    private var _binding: FragmentDaftarUangMasukBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DaftarUangMasukViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDaftarUangMasukBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        admissionFeeAdapter = AdmissionFeeAdapter(
            onDeleteClick = { admissionFee ->
                // Delete item
                viewModel.deleteAdmissionFee(admissionFee)
            },
            onEditClick = { admissionFee ->
                val bundle = Bundle().apply {
                    putParcelable("admission_fee", admissionFee)
                }

                val inputUangMasukFragment = InputUangMasukFragment().apply {
                    arguments = bundle
                }

                val fragmentManager = parentFragmentManager
                fragmentManager.beginTransaction().apply {
                    replace(R.id.frame_container, inputUangMasukFragment, InputUangMasukFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
//
            }
        )

        setList()

        binding.rvAdmissionFee!!.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = admissionFeeAdapter
        }

        binding.btnDate!!.setOnClickListener {
//            showDateRangePicker()
//            setTotal()
        }


        binding.btnCreate!!.setOnClickListener {
            val inputUangMasukFragment = InputUangMasukFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, inputUangMasukFragment, InputUangMasukFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun setTotal(date: Long) {
//        viewModel.getTotalByDate(date).observe(viewLifecycleOwner, {total ->
//            if (total != null) {
//                binding.tvTotal!!.text = total.toString()
//            }
//        })
//    }

    private val totalObserver = Observer<List<AdmissionFee>> { admissionFee ->
        admissionFeeAdapter.submitList(admissionFee)

    }

    private fun setList() {
        viewModel.getAllAdmissionFee().observe(viewLifecycleOwner, admissionFeeObserver)
    }

    private val admissionFeeObserver = Observer<List<AdmissionFee>> { admissionFee ->
        admissionFeeAdapter.submitList(admissionFee)

    }

//    private fun showDateRangePicker() {
//        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker()
//            .setTitleText("Select date range")
//            .build()
//
//        dateRangePicker.show(parentFragmentManager, "DATE_PICKER")
//
//        dateRangePicker.addOnPositiveButtonClickListener { selection ->
//            val (startDate, endDate) = selection ?: Pair(null, null)
//            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//
//            val startDateStr = startDate?.let { dateFormat.format(Date(it)) } ?: "No start date"
//            val endDateStr = endDate?.let { dateFormat.format(Date(it)) } ?: "No end date"
//
//            Toast.makeText(requireContext(), "Selected range: $startDateStr - $endDateStr", Toast.LENGTH_SHORT).show()
//        }
//
//        dateRangePicker.addOnNegativeButtonClickListener {
//        }
//    }

}