package com.mingyuans.smoke;
/*****************************************************************************
 Copyright mingyuans

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ******************************************************************************/

import java.util.List;

/**
 * Created by yanxq on 17/3/15.
 */

public class ConsolePrinter extends Smoke.Process{

    @Override
    public boolean proceed(Smoke.LogBean logBean, List<String> messages, Chain chain) {
        if (CollectionUtil.isEmpty(messages)) {
            return true;
        }

        StringBuilder builder = new StringBuilder();
        for (String line : messages) {
            builder.append(line.endsWith("\n")? line : line + "\n");
        }
        System.out.println(builder.toString());
        return chain.proceed(logBean,messages);
    }
}
