package br.com.fsdev.learningapp.ui.list

import android.view.View
import br.com.fsdev.learningapp.R
import br.com.fsdev.learningapp.databinding.ItemRowBinding
import br.com.fsdev.learningapp.domain.models.Character
import com.xwray.groupie.viewbinding.BindableItem

class CharacterEntry(
    val item: Character
): BindableItem<ItemRowBinding>() {

    override fun bind(viewBinding: ItemRowBinding, position: Int) =
        with(viewBinding) {
            itemRowTitle.text = item.name
            itemRowDescription.text = item.status.name
        }

    override fun getLayout(): Int = R.layout.item_row

    override fun initializeViewBinding(view: View): ItemRowBinding =
        ItemRowBinding.bind(view)

}