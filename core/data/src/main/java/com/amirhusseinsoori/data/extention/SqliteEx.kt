package com.amirhusseinsoori.data.extention

import android.content.Context
import com.amirhusseinsoori.common.Constance
import com.amirhusseinsoori.data.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver


fun Context.createDatabaseDriver() = AndroidSqliteDriver(
    schema = Database.Schema,
    context = this,
    name = Constance.DbName,
)