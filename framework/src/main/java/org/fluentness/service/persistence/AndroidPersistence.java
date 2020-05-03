package org.fluentness.service.persistence;

import android.os.Environment;
import org.fluentness.service.log.Log;

import java.io.IOException;

public class AndroidPersistence extends FilePersistence {
    public AndroidPersistence(Log log) throws IOException {
        super(Environment.getExternalStorageDirectory().toString(), log);
    }

}
