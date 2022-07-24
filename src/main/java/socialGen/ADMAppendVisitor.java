/*
 * Copyright by The Regents of the University of California
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License from
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package socialGen;

import datatype.Date;
import datatype.DateTime;
import datatype.Point;

public class ADMAppendVisitor extends AbstractAppendVisitor implements IAppendVisitor {

    String startList() {
        return "[";
    }

    String endList() {
        return "]";
    }

    String startBag() {
        return "{{";
    }

    String endBag() {
        return "}}";
    }

    public IAppendVisitor visit(long l) {
        builder.append("int64(\"").append(l).append("\")");
        return this;
    }

    public IAppendVisitor visit(Date date) {
        builder.append("date(\"");
        date.accept(this);
        builder.append("\")");
        return this;
    }

    public IAppendVisitor visit(DateTime datetime) {
        builder.append("datetime(\"");
        datetime.accept(this);
        builder.append("\")");
        return this;
    }


    @Override
    public IAppendVisitor visit(Point point, boolean isGeo) {
        if(isGeo){
            builder.append("\"POINT (").append(point.getLatitude()).append(" ").append(point.getLongitude()).append(")\"");
        }else{
            builder.append("point(\"").append(point.getLatitude()).append(", ").append(point.getLongitude()).append("\")");
        }
        return this;
    }
}
