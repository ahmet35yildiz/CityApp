package com.example.cityapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cityapp.R
import com.example.cityapp.data.entity.NewsInfo
import com.example.cityapp.databinding.FragmentBottomSheetBinding
import com.example.cityapp.databinding.FragmentNewsBinding
import com.example.cityapp.ui.adapter.NewsAdapter
import com.example.cityapp.ui.viewmodel.NewsFragmentViewModel
import com.example.cityapp.util.showSnackbar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    private val viewModel: NewsFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newsList.observe(viewLifecycleOwner) {
            with(binding) {
                newsFragment = this@NewsFragment

                if (it != null) {
                    val adapter = NewsAdapter(it) {
                        showDialog(it)
                    }
                    newsAdapter = adapter
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.GONE
                } else {
                    animationLoading.visibility = View.GONE
                    animationError.visibility = View.VISIBLE
                    showSnackbar(view,"Bir hata oluştu, lütfen daha sonra tekrar deneyiniz.")
                }
            }
        }
    }

    private fun showDialog(news: NewsInfo) {
        val bottomSheetDialog = BottomSheetDialog(requireContext())

        val binding: FragmentBottomSheetBinding =
            FragmentBottomSheetBinding.inflate(LayoutInflater.from(requireContext()))
        bottomSheetDialog.setContentView(binding.root)

        with(binding) {

            textViewNewsDescription.text = news.newsDescription

            Picasso.get().load(news.newsImage).into(imageViewNews)

            btnBottomSheet.setOnClickListener { //bottom sheet'daki butona tıklandığında haber sitesine yönlendirilir
                val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(news.newsUrl))
                ContextCompat.startActivity(it.context, intent, null)
            }
        }

        bottomSheetDialog.show()
    }
}