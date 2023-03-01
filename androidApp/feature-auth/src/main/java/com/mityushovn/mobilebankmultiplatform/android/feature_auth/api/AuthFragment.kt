package com.mityushovn.mobilebankmultiplatform.android.feature_auth.api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberFragment.PhoneNumberScreen
import com.mityushovn.mobilebankmultiplatform.shared.auth.api.AuthVmFactories
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberViewModel

class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val viewModel: PhoneNumberViewModel = viewModel(factory = AuthVmFactories.phoneNumberVMFactory)
                PhoneNumberScreen(viewModel = viewModel)
            }
        }
    }

}