package com.zaniva.githubuserappv3.ui.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaniva.githubuserappv3.R
import com.zaniva.githubuserappv3.databinding.FollowTablayoutBinding
import com.zaniva.githubuserappv3.ui.home.Adapter

class FollowingFragment : Fragment(R.layout.follow_tablayout){
    private var _binding: FollowTablayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var un: String
    private lateinit var vm: FollowingVM
    private lateinit var adapter: Adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        un = args?.getString(UserActivity.UN).toString()
        _binding = FollowTablayoutBinding.bind(view)

        adapter = Adapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvFollow.setHasFixedSize(true)
            rvFollow.layoutManager = LinearLayoutManager(activity)
            rvFollow.adapter = adapter
        }

        isLoading(true)
        vm = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(FollowingVM::class.java)
        vm.set(un)
        vm.get().observe(viewLifecycleOwner){
            if(it != null){
                adapter.setList(it)
                isLoading(false)
            }
        }

    }

    fun isLoading(s: Boolean){
        if (s){
            binding.pbUser.visibility = View.VISIBLE
        }
        else {
            binding.pbUser.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}