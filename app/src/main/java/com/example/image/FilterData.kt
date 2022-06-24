package com.example.image

object FilterData {
    //dark
    private val dark_matrix = floatArrayOf(
        0.5f, 0f, 0f, 0f, 0f,
        0f, 0.5f, 0f, 0f, 0f,
        0f, 0f, 0.5f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f,
    )

    //gray
    private val gray_matrix = floatArrayOf(
        0.33f, 0.59f, 0.11f, 0f, 0f,
        0.33f, 0.59f, 0.11f, 0f, 0f,
        0.33f, 0.59f, 0.11f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f,
    )

    //reverse
    private val reverse_matrix = floatArrayOf(
        -1f, 0f, 0f, 1f, 1f,
        0f, -1f, 0f, 1f, 1f,
        0f, 0f, -1f, 1f, 1f,
        0f, 0f, 0f, 1f, 0f,
    )

    //blueToRed
    private val blue2Red_matrix = floatArrayOf(
        0f, 0f, 1f, 0f, 0f,
        0f, 1f, 0f, 0f, 0f,
        1f, 0f, 0f, 0f, 0f,
        0f, 0f, 0f, 1f, 0f,
    )

    //old photo
    private val old_matrix = floatArrayOf(
        0.393f, 0.769f, 0.189f, 0f, 0f,
        0.349f, 0.686f, 0.168f, 0f, 0f,
        0.272f, 0.534f, 0.131f, 0f, 0f, 0f, 0f, 0f, 1f, 0f
    )

    //desaturate
    private val desaturate_matrix = floatArrayOf(
        1.5f, 1.5f, 1.5f, 0f, -1f,
        1.5f, 1.5f, 1.5f, 0f, -1f,
        1.5f, 1.5f, 1.5f, 0f, -1f, 0f, 0f, 0f, 1f, 0f
    )

    //strengthen
    private val strengthen_matrix = floatArrayOf(
        1.438f, -0.122f, -0.016f, 0f, -0.03f,
        -0.062f, 1.378f, -0.016f, 0f, 0.05f,
        -0.062f, -0.122f, 1.483f, 0f, -0.02f, 0f, 0f, 0f, 1f, 0f
    )

    private val filterArrays = arrayListOf(
        null,
        dark_matrix,
        gray_matrix,
        reverse_matrix,
        blue2Red_matrix,
        old_matrix,
        desaturate_matrix,
        strengthen_matrix
    )
    private val nameArrays = arrayListOf("原图","变暗", "灰白", "反相", "变色", "老照片", "去色", "饱和度加强")
    val filters = arrayListOf<FilterModel>()

    init {
        for ((index, name) in nameArrays.withIndex()) {
            filters.add(FilterModel(name, filterArrays[index]))
        }
    }
}

class FilterModel(name: String, array: FloatArray?) {
    val filterName = name;
    val filterArray = array;
}