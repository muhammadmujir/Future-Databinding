package com.natashaval.futuredatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.natashaval.futuredatabinding.ProfileActivity.Companion.FIRST_NAME_KEY
import com.natashaval.futuredatabinding.ProfileActivity.Companion.LAST_NAME_KEY

class ProfileFragment : DialogFragment() {
    private var firstName: String? = null
    private var lastName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString(FIRST_NAME_KEY)
            lastName = it.getString(LAST_NAME_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // TODO: B4. implement how to use viewBinding in Fragment
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: B5. change firstName and lastName to your own name with viewbinding
        val firstNameText = view.findViewById<TextView>(R.id.tv_first_name)
        firstNameText.text = firstName

        val lastNameText = view.findViewById<TextView>(R.id.tv_last_name)
        lastNameText.text = lastName
    }

    companion object {
        fun newInstance(firstName: String, lastName: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(FIRST_NAME_KEY, firstName)
                    putString(LAST_NAME_KEY, lastName)
                }
            }
        const val TAG = "ProfileFragment"
    }
}