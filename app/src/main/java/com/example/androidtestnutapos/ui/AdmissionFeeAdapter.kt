package com.example.androidtestnutapos.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtestnutapos.databinding.ItemCardAdmissionBinding
import com.example.androidtestnutapos.domain.model.AdmissionFee
import com.example.androidtestnutapos.ui.dialog.ImagePreviewDialog

class AdmissionFeeAdapter(
    private val onEditClick: (AdmissionFee) -> Unit,
    private val onDeleteClick: (AdmissionFee) -> Unit
) : ListAdapter<AdmissionFee, AdmissionFeeAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdmissionFeeAdapter.ViewHolder {
        val binding =
            ItemCardAdmissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdmissionFeeAdapter.ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ViewHolder(private val binding: ItemCardAdmissionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(admissionFee: AdmissionFee) {

            with(binding) {
                tvToAndFrom.text = "Dari ${admissionFee.from} ke ${admissionFee.to}"
                tvTime.text = admissionFee.date.toString()
                tvTotal.text = admissionFee.total.toString()
                tvDescription.text = admissionFee.description

                if (admissionFee.image != null) {
                    tvShowFoto.setOnClickListener {
                        val imagePreviewDialogFragment = ImagePreviewDialog(admissionFee.image.toUri())
                        imagePreviewDialogFragment.show((itemView.context as AppCompatActivity).supportFragmentManager, "imagePreviewDialog")
                    }
                }

                binding.btnDelete.setOnClickListener {
                    onEditClick
                }

                binding.btnDelete.setOnClickListener {
                    onDeleteClick
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<AdmissionFee>() {
                override fun areItemsTheSame(
                    oldItem: AdmissionFee,
                    newItem: AdmissionFee,
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: AdmissionFee,
                    newItem: AdmissionFee,
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}