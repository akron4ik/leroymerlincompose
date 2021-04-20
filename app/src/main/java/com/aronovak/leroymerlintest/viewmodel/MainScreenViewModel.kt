package com.aronovak.leroymerlintest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aronovak.leroymerlintest.data.bestPriceProductsList
import com.aronovak.leroymerlintest.data.itemCatalogList
import com.aronovak.leroymerlintest.data.limitedOfferProductsList
import com.aronovak.leroymerlintest.data.recentlyProductsList
import com.aronovak.leroymerlintest.ui.components.ItemCatalog
import com.aronovak.leroymerlintest.ui.components.Product

class MainScreenViewModel: ViewModel() {
    private val _searchText:MutableLiveData<String> = MutableLiveData("")
    val searchText = _searchText

    private val _recentlyOfProducts: MutableLiveData<List<Product>> = MutableLiveData(recentlyProductsList)
    val recentlyOfProducts = _recentlyOfProducts

    private val _limitedOfferProducts: MutableLiveData<List<Product>> = MutableLiveData(limitedOfferProductsList)
    val limitedOfferProducts = _limitedOfferProducts

    private val _bestPriceProducts: MutableLiveData<List<Product>> = MutableLiveData(bestPriceProductsList)
    val bestPriceProducts = _bestPriceProducts

    private val _catalogItems: MutableLiveData<List<ItemCatalog>> = MutableLiveData(itemCatalogList)
    val catalogItems = _catalogItems

    fun setSearchText(text: String){
        _searchText.postValue(text)
    }
}