package com.example.mod5demo4

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordFieldTest {

    //récuperer l'objet qui permet les tests
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun textFieldPasswordisWorking() {
        //tester si le champ de mot de passe est fonctionnel

        composeTestRule.setContent { PasswordTextField() }

        composeTestRule.onNodeWithTag("PasswordTextField").assertExists("Input introuvable")

        composeTestRule.onNodeWithTag("PasswordTextField").performTextInput("123456")

        composeTestRule.onNodeWithContentDescription("Show password").performClick()

        composeTestRule.onNodeWithContentDescription("Hide password").assertIsDisplayed()

    }
}