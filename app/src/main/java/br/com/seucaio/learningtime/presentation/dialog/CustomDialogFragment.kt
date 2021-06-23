package br.com.seucaio.learningtime.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class CustomDialogFragment: DialogFragment() {

    private val args: CustomDialogFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setMessage(args.message)
            .setPositiveButton("Sim") {_,_ ->
                val action = CustomDialogFragmentDirections
                        .actionNavigationDialogFragmentToNavigationPopularMovies()
                findNavController().navigate(action)
            }
            .create()
    }
}