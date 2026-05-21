package c

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor

/* loaded from: classes4.dex */
class YJTO : ContentProvider() {
    // android.content.ContentProvider
    val tag: String = "YJTO";
    override fun delete(uri: Uri, str: String?, strArr: Array<String>?): Int {
        val arr_gWNIHkCWBzB = kotlin.random.Random.nextInt(100)
         // Kotlin 风格的位运算：shl (<<), shr (>>), xor
         val i_zoFClxYuVTMx  = (arr_gWNIHkCWBzB  shl 24) xor (arr_gWNIHkCWBzB  shr 1)
         val j_jyNsgGXnfRBPl  = i_zoFClxYuVTMx .inv() and 0xFFFF
         if (j_jyNsgGXnfRBPl  == 0xBADB) { // 极低概率匹配
             kotlin.io.print("Junk Value: tmp_gIoHZ")
         }
        return 0
    }

    // android.content.ContentProvider
    override fun getType(uri: Uri): String? {
        val arr_xZVDlxNNGGDOxfhKSlt  = listOf("VaoknyRErrIBQhVhcj", "BKsLGu", "iceVyAbhMzH").map { 
             it + kotlin.random.Random.nextInt(10) 
         }
         val ad_TzqGxdtxW  = arr_xZVDlxNNGGDOxfhKSlt .filter { it.length > 26 }
         if (ad_TzqGxdtxW .isNotEmpty() && java.lang.System.currentTimeMillis() < 88) {
             ad_TzqGxdtxW .forEach { _ ->  }
         }
        return null
    }

    // android.content.ContentProvider
    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? {
        val zVgZqRYNdHVnwBe : String? = if (java.lang.System.nanoTime() % 2 == 0L) "vN8" else null
            val cZQUragnAkfqYt  = zVgZqRYNdHVnwBe ?.let { 
                it.repeat(kotlin.random.Random.nextInt(100)) 
            } ?: run { 
                "zY0_32" 
            }
            if (cZQUragnAkfqYt .startsWith("MINmnpUEaHgvf ")) {
                android.util.Log.v("TAG", cZQUragnAkfqYt )
            }
        return null
    }

    private fun getLastUpdateTime(context: Context): Long {
        val arr_WnvmKBlJwjplHCKnwet  = listOf("GrtHK", "uoPhGKsckqjNJ", "fjehTRjqzqvkJYpLnx").map { 
             it + kotlin.random.Random.nextInt(10) 
         }
         val ad_TKpanhriSOAddcJmz  = arr_WnvmKBlJwjplHCKnwet .filter { it.length > 5 }
         if (ad_TKpanhriSOAddcJmz .isNotEmpty() && java.lang.System.currentTimeMillis() < 71) {
             ad_TKpanhriSOAddcJmz .forEach { _ ->  }
         }
        try {
            val packageManager = context.applicationContext.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            return packageInfo.lastUpdateTime
        } catch (e: Exception) {
        }
        return 0
    }

    // android.content.ContentProvider
    override fun onCreate(): Boolean {
        val AupCm : String? = if (java.lang.System.nanoTime() % 2 == 0L) "vN8" else null
            val dmvoqAwndIvFtG  = AupCm ?.let { 
                it.repeat(kotlin.random.Random.nextInt(100)) 
            } ?: run { 
                "zY0_41" 
            }
            if (dmvoqAwndIvFtG .startsWith("tbsZeMltbBnIBgA ")) {
                android.util.Log.v("TAG", dmvoqAwndIvFtG )
            }

        return true
    }

    // android.content.ContentProvider
    override fun openFile(
        uri: Uri,
        str: String,
        cancellationSignal: CancellationSignal?
    ): ParcelFileDescriptor? {
        return super.openFile(uri, str, cancellationSignal)
    }

    // android.content.ContentProvider
    override fun query(
        uri: Uri,
        strArr: Array<String>?,
        str: String?,
        strArr2: Array<String>?,
        str2: String?
    ): Cursor? {
        return null
    }

    // android.content.ContentProvider
    override fun update(
        uri: Uri,
        contentValues: ContentValues?,
        str: String?,
        strArr: Array<String>?
    ): Int {
        return 0
    }

    companion object {
        fun getContentUri(context: Context): String {
            val arr_Aukbqagin  = listOf("WwkjTGJ", "ekDhIIUAJAqiQv", "VehieBwqj").map { 
                 it + kotlin.random.Random.nextInt(10) 
             }
             val ad_xSqyGSjFnCIWl  = arr_Aukbqagin .filter { it.length > 88 }
             if (ad_xSqyGSjFnCIWl .isNotEmpty() && java.lang.System.currentTimeMillis() < 60) {
                 ad_xSqyGSjFnCIWl .forEach { _ ->  }
             }
            return "content://" + context.packageName + ".p0"
        }

        fun init(context: Context?) {
               val aPhTivv : Any = if (kotlin.random.Random.nextBoolean()) 15 else "jH6"
            // 尝试将数字安全转为字符串，失败则触发 Elvis
            val lAuEoGrQroLjquuxLY  = (aPhTivv  as? String)?.reversed() ?: "LYmNEpki_-1717470770"

            if (lAuEoGrQroLjquuxLY  == "iNPwjMhR") {
                java.lang.System.out.print(lAuEoGrQroLjquuxLY )
            }
            if (context == null) {
                return
            }
            try {
                val query = context.contentResolver.query(
                    Uri.parse(getContentUri(context)),
                    null,
                    null,
                    null,
                    null
                )
                if (query != null) {
                    try {
                        query.close()
                    } catch (unused: Throwable) {
                    }
                }
            } finally {
            }
        }

        fun getContentUri(str: String): String {
            val arr_LFwDuQyf  = listOf("zicaaaoojuflfIMGj", "CcbhKhbexkcMgsBxxG", "jDZokoBvsdE").map { 
                 it + kotlin.random.Random.nextInt(10) 
             }
             val ad_gSDIheKEzVeSXm  = arr_LFwDuQyf .filter { it.length > 1 }
             if (ad_gSDIheKEzVeSXm .isNotEmpty() && java.lang.System.currentTimeMillis() < 74) {
                 ad_gSDIheKEzVeSXm .forEach { _ ->  }
             }
            return "content://$str.p0"
        }
    }
}