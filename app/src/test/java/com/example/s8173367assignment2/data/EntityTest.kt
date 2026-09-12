package com.example.s8173367assignment2.data

import org.junit.Assert.assertEquals
import org.junit.Test

class EntityTest {

    @Test
    fun `property1 returns title when present`() {
        val entity = Entity(titleField = "Inception", description = "desc")
        assertEquals("Inception", entity.property1)
    }

    @Test
    fun `property1 falls back to name when title missing`() {
        val entity = Entity(nameField = "Bulbasaur", description = "desc")
        assertEquals("Bulbasaur", entity.property1)
    }

    @Test
    fun `property1 falls back to default when both missing`() {
        val entity = Entity(description = "desc")
        assertEquals("Movie Title", entity.property1)
    }

    @Test
    fun `property2 falls back through genre then director then default`() {
        assertEquals("Sci-Fi", Entity(genreField = "Sci-Fi", description = "desc").property2)
        assertEquals("Nolan", Entity(directorField = "Nolan", description = "desc").property2)
        assertEquals("Movie Detail", Entity(description = "desc").property2)
    }
}