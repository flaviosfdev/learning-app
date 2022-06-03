package br.com.fsdev.learningapp.ui.list

import android.view.View
import br.com.fsdev.learningapp.R
import br.com.fsdev.learningapp.databinding.ItemRowBinding
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.models.Location
import com.xwray.groupie.viewbinding.BindableItem

class LocationEntry(
    val item: Location
): BindableItem<ItemRowBinding>() {

    override fun bind(viewBinding: ItemRowBinding, position: Int) =
        with(viewBinding) {
            itemRowTitle.text = item.name
            itemRowDescription.text = item.type
        }

    override fun getLayout(): Int = R.layout.item_row

    override fun initializeViewBinding(view: View): ItemRowBinding =
        ItemRowBinding.bind(view)

}