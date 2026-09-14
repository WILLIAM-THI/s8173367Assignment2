package com.example.s8173367assignment2.ui

import com.example.s8173367assignment2.data.Entity
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EntityAdapterTest {

    private lateinit var adapter: EntityAdapter

    @Before
    fun setup() {
        adapter = spyk(EntityAdapter(onItemClick = {}))
        every { adapter.notifyDataSetChanged() } just Runs
    }

    @Test
    fun `getItemCount is zero before any data is set`() {
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun `updateData sets itemCount to match the new list size`() {
        val entities = listOf(
            Entity(titleField = "Inception", description = "desc 1"),
            Entity(titleField = "Interstellar", description = "desc 2"),
            Entity(titleField = "Tenet", description = "desc 3")
        )

        adapter.updateData(entities)

        assertEquals(3, adapter.itemCount)
    }

    @Test
    fun `updateData replaces the old list rather than appending to it`() {
        adapter.updateData(listOf(Entity(titleField = "Inception", description = "desc")))
        assertEquals(1, adapter.itemCount)

        adapter.updateData(
            listOf(
                Entity(titleField = "Interstellar", description = "desc"),
                Entity(titleField = "Tenet", description = "desc")
            )
        )

        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun `updateData with an empty list clears itemCount back to zero`() {
        adapter.updateData(listOf(Entity(titleField = "Inception", description = "desc")))
        assertEquals(1, adapter.itemCount)

        adapter.updateData(emptyList())

        assertEquals(0, adapter.itemCount)
    }
}