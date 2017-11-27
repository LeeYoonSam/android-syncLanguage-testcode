package com.ys.test.androidtestsamples.io

import com.ys.test.androidtestsamples.entity.UserEntity
import org.amshove.kluent.shouldEqual
import org.junit.Test

/**
 * Created by Albert-IM on 27/11/2017.
 */
class SerializerTest {
    private val JSON_RESPONSE = "{\n \"id\": 1,\n " +
            "\"cover_url\": \"http://www.android10.org/myapi/cover_1.jpg\",\n " +
            "\"full_name\": \"Simon Hill\",\n " +
            "\"description\": \"Curabitur gravida nisi at nibh. In hac habitasse " +
            "platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer " +
            "eget, rutrum at, lorem.\\n\\nInteger tincidunt ante vel ipsum. " +
            "Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo " +
            "placerat.\\n\\nPraesent blandit. Nam nulla. Integer pede justo, " +
            "lacinia eget, tincidunt eget, tempus vel, pede.\",\n " +
            "\"followers\": 7484,\n " +
            "\"email\": \"jcooper@babbleset.edu\"\n}"

    private var serializer = Serializer()

    @Test
    fun shouldSerialize() {
        val userEntityOne = serializer.deserialize(JSON_RESPONSE, UserEntity::class.java)
        val jsonStringUserOne = serializer.serialize(userEntityOne, UserEntity::class.java)
        val userEntityTwo = serializer.deserialize(jsonStringUserOne, UserEntity::class.java)

        userEntityOne.userId shouldEqual userEntityTwo.userId
        userEntityOne.coverUrl shouldEqual userEntityTwo.coverUrl
        userEntityOne.description shouldEqual userEntityTwo.description
        userEntityOne.email shouldEqual userEntityTwo.email
    }

    @Test
    fun shouldDesearialize() {
        val userEntity = serializer.deserialize(JSON_RESPONSE, UserEntity::class.java)

        userEntity.userId shouldEqual 1
        userEntity.fullname shouldEqual "Simon Hill"
        userEntity.followers shouldEqual 7484
    }
}