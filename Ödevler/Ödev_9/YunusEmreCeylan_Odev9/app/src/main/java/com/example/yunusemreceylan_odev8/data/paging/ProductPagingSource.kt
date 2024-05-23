    package com.example.yunusemreceylan_odev8.data.paging

    import androidx.paging.PagingSource
    import androidx.paging.PagingState
    import com.example.yunusemreceylan_odev8.data.api.ProductService
    import com.example.yunusemreceylan_odev8.data.model.Product
    import com.example.yunusemreceylan_odev8.data.model.ProductList
    import retrofit2.HttpException
    import java.io.IOException

    class ProductPagingSource(
        private val service: ProductService,
        private val query: String
    ) : PagingSource<Int, Product>() {

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
            val position = params.key ?: 0
            val limit = params.loadSize

            return try {
                val response = service.getProducts(limit, position)
                val productList: ProductList = response.body() ?: ProductList(emptyList(), 0, 0, 0)
                val products = productList.products

                LoadResult.Page(
                    data = products,
                    prevKey = if (position == 0) null else position - limit,
                    nextKey = if (products.isEmpty()) null else position + limit
                )
            } catch (exception: IOException) {
                LoadResult.Error(exception)
            } catch (exception: HttpException) {
                LoadResult.Error(exception)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey?.plus(state.config.pageSize)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(state.config.pageSize)
            }
        }
    }
