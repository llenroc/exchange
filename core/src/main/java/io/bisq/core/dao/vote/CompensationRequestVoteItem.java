/*
 * This file is part of bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.core.dao.vote;

import com.google.protobuf.Message;
import io.bisq.common.app.Version;
import io.bisq.common.persistable.PersistablePayload;
import io.bisq.core.dao.compensation.CompensationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CompensationRequestVoteItem implements PersistablePayload {
    // That object is saved to disc. We need to take care of changes to not break deserialization.
    private static final long serialVersionUID = Version.LOCAL_DB_VERSION;
    private static final Logger log = LoggerFactory.getLogger(CompensationRequestVoteItem.class);

    public final CompensationRequest compensationRequest;
    private boolean declineVote;
    private boolean acceptedVote;
    private boolean hasVoted;

    public CompensationRequestVoteItem(CompensationRequest compensationRequest) {
        this.compensationRequest = compensationRequest;
    }

    public void setDeclineVote(boolean declineVote) {
        this.declineVote = declineVote;
        this.hasVoted = true;
    }

    public boolean isDeclineVote() {
        return declineVote;
    }

    public void setAcceptedVote(boolean acceptedVote) {
        this.acceptedVote = acceptedVote;
        this.hasVoted = true;
    }

    public boolean isAcceptedVote() {
        return acceptedVote;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "CompensationRequestVoteItem{" +
                "compensationRequest=" + compensationRequest +
                ", declineVote=" + declineVote +
                ", acceptedVote=" + acceptedVote +
                ", hasVoted=" + hasVoted +
                '}';
    }

    // TODO not impl yet
    @Override
    public Message toProtoMessage() {
        return null;
    }
}