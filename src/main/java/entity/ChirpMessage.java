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
package entity;

import java.util.List;

import datatype.DateTime;
import datatype.Message;
import datatype.Point;
import socialGen.ADMAppendVisitor;
import socialGen.IAppendVisitor;

public class ChirpMessage {

    private long chirpId;
    private ChirpUser user;
    private Point senderLocation;
    private DateTime sendTime;
    private List<String> referredTopics;
    private int sentiment;
    private Message messageText;

    public ChirpMessage() {

    }

    public ChirpMessage(long chirpId, ChirpUser user, Point senderLocation, DateTime sendTime,
            List<String> referredTopics, int sentiment, Message messageText) {
        this.chirpId = chirpId;
        this.user = user;
        this.senderLocation = senderLocation;
        this.sendTime = sendTime;
        this.referredTopics = referredTopics;
        this.sentiment = sentiment;
        this.messageText = messageText;
    }

    public void reset(long chirpId, ChirpUser user, Point senderLocation, DateTime sendTime,
                      List<String> referredTopics, int sentiment, Message messageText) {
        this.chirpId = chirpId;
        this.user = user;
        this.senderLocation = senderLocation;
        this.sendTime = sendTime;
        this.referredTopics = referredTopics;
        this.sentiment = sentiment;
        this.messageText = messageText;
    }

    public String toString() {
        return accept(new ADMAppendVisitor()).toString();
    }

    public IAppendVisitor accept(IAppendVisitor visitor) {
        visitor.append("{\"chirpid\": ").visit(chirpId);
        visitor.append(", \"user\": ").visit(user);
        visitor.append(", \"sender_location_point\": ").visit(senderLocation,false);
        visitor.append(", \"sender_location_geometry\": ").visit(senderLocation,true);
        visitor.append(", \"send_time\": ").visit(sendTime);
        visitor.append(", \"referred_topics\": ").visit(referredTopics);
        visitor.append(", \"sentiment\": ").visit(sentiment);
        visitor.append(", \"message_text\": ").visit(messageText);
        return visitor.append("}");
    }

}
