package ru.mobile.data.mappers

import ru.mobile.data.db.ProductItemEntity
import ru.mobile.domain.model.DomainProductItemModel

interface ProductItemMapper {
    fun mapToDomain(entity: ProductItemEntity): DomainProductItemModel
}

internal class ProductItemMapperImpl : ProductItemMapper {

    override fun mapToDomain(entity: ProductItemEntity): DomainProductItemModel {
        return with(entity) {
            DomainProductItemModel(
                id = id,
                title = name,
                date = time,
                tags = tags,
                amount = amount,
            )
        }
    }
}
