package com.example.androidtestnutapos.ui.inputuangmasuk

import android.app.AlertDialog
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.example.androidtestnutapos.R
import com.example.androidtestnutapos.databinding.DialogImagePickerBinding
import com.example.androidtestnutapos.databinding.FragmentDaftarUangMasukBinding
import com.example.androidtestnutapos.databinding.FragmentInputUangMasukBinding
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.ui.daftaruangmasuk.DaftarUangMasukViewModel
import com.example.androidtestnutapos.ui.dialog.BottomSheetDialog
import com.example.androidtestnutapos.utils.Utils.getImageUri
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputUangMasukFragment : Fragment() {

    private var _binding: FragmentInputUangMasukBinding? = null
    private val binding get() = _binding!!

    private val viewModel: InputUangMasukViewModel by viewModels()

    private var admissionFee: AdmissionFee? = null

    private var currentImageUri: Uri? = null

    private var selectedSpinner: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputUangMasukBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            admissionFee = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable("admission_fee", AdmissionFee::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.getParcelable("admission_fee")
            }
        }

        if(admissionFee != null) {
            admissionFee?.let {
                binding.tvDari.text = it.from
                binding.tvMasukKe.text = it.to
                binding.tvJumlah.text = it.total.toString()
                binding.tvKeterangan.text = it.description
                binding.ivBukti

            }

//        viewModel.updateAdmissionFee()

        }


        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.spinner_items,
                    R.layout.spinner_item,
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            binding.dropdownJenis.adapter = adapter
        }

        binding.dropdownJenis.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position) as String
                selectedSpinner = selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        binding.ivBukti.setOnClickListener {
            showImageOptionsDialog()
        }

        binding.tvLebihTahu.setOnClickListener {
            BottomSheetDialog.show(parentFragmentManager)
        }

//        viewModel.insertAdmissionFee()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showImageOptionsDialog() {

        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_image_picker, null)

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        val takeCamera = dialogView.findViewById<LinearLayout>(R.id.take_camera)
        val takeGallery = dialogView.findViewById<LinearLayout>(R.id.take_gallery)

        takeCamera.setOnClickListener {
            dialogBuilder.dismiss()
            startCamera()
        }

        takeGallery.setOnClickListener {
            dialogBuilder.dismiss()
            startGallery()
        }

        dialogBuilder.show()
    }

    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun startCamera() {
        currentImageUri = getImageUri(requireActivity())
        launcherIntentCamera.launch(currentImageUri!!)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        } else {
            currentImageUri = null
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.ivBukti.setImageURI(it)
        }
    }
}