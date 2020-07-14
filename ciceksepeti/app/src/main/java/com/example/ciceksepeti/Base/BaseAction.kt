package com.example.ciceksepeti.Base

interface BaseDataType

open class BaseViewModelAction

data class Loading(val loading: Boolean, val externalType: Int? = null) : BaseViewModelAction()

data class HasError(val message: String?, val type: BaseDataType = DataType.NONE) :
    BaseViewModelAction() {

    enum class DataType : BaseDataType { NONE, GO_BACK, DIALOG, SNACK_BAR, DIALOG_GO_BACK }
}

data class ContentLoaded<out T>(val data: T, val type: BaseDataType? = null) :
    BaseViewModelAction()

data class ItemClicked<out T>(val item: T, val type: BaseDataType? = null) : BaseViewModelAction()
