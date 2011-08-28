package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNstdPtys4SubGrp;

public class FixNestedParties4
{

	public int noNested4PartyIDs;
	public NestedParties4[] group;

	public void getAll(int noNested4PartyIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noNested4PartyIDs = noNested4PartyIDs;

		if (noNested4PartyIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noNested4PartyIDs ).getBytes(), FixTags.NONESTED4PARTYIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noNested4PartyIDs) {
			group = new NestedParties4[noNested4PartyIDs];

			for ( int i = 0; i < noNested4PartyIDs; i++ ) group[i] = new NestedParties4();
	}

		for ( int i = 0; i < noNested4PartyIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNested4PartyIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNested4PartyIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNested4PartyIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedParties4)) return false;

		FixNestedParties4 msg = (FixNestedParties4) o;

		for (int i = 0; i<noNested4PartyIDs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNested4PartyIDs; i++)
			s += group[i].toString();
		return s;
	}

public class NestedParties4 implements FixComponent
{

	public byte[] nested4PartyID;
	public byte nested4PartyIDSource = (byte)' ';
	public long nested4PartyRole = 0;
	public FixNstdPtys4SubGrp nstdPtys4SubGrp;

	public NestedParties4() {
		super();

		nested4PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nstdPtys4SubGrp = new FixNstdPtys4SubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( nested4PartyID, (byte)0 );
		nested4PartyIDSource = Byte.MAX_VALUE;		
		nested4PartyRole = Long.MAX_VALUE;		
		nstdPtys4SubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTED4PARTYID_INT) {
				nested4PartyID = FixUtils.getTagStringValue(null ,id ,value, nested4PartyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTED4PARTYIDSOURCE_INT) {
				nested4PartyIDSource = FixUtils.getTagCharValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTED4PARTYROLE_INT) {
				nested4PartyRole = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTED4PARTYSUBIDS_INT) {
				int noNested4PartySubIDs;
				noNested4PartySubIDs = FixUtils.getTagIntValue(null ,id ,value );
				nstdPtys4SubGrp.getAll(noNested4PartySubIDs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(nested4PartyID)) return true;
		if (FixUtils.isSet(nested4PartyIDSource)) return true;
		if (FixUtils.isSet(nested4PartyRole)) return true;
		if (FixUtils.isSet(nstdPtys4SubGrp.noNested4PartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nested4PartyID)) FixUtils.putFixTag( out, FixTags.NESTED4PARTYID_INT, nested4PartyID, 0, Utils.lastIndexTrim(nested4PartyID, (byte)0) );
		if (FixUtils.isSet(nested4PartyIDSource)) FixUtils.putFixTag( out, FixTags.NESTED4PARTYIDSOURCE_INT, nested4PartyIDSource );
		if (FixUtils.isSet(nested4PartyRole)) FixUtils.putFixTag( out, FixTags.NESTED4PARTYROLE_INT, nested4PartyRole);
		if (FixUtils.isSet(nstdPtys4SubGrp.noNested4PartySubIDs)) nstdPtys4SubGrp.encode( out );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(nested4PartyID)) s += "Nested4PartyID(1415)=" + new String(nested4PartyID) + sep;
			if (FixUtils.isSet(nested4PartyIDSource)) s += "Nested4PartyIDSource(1416)=" + String.valueOf(nested4PartyIDSource) + sep;
			if (FixUtils.isSet(nested4PartyRole)) s += "Nested4PartyRole(1417)=" + String.valueOf(nested4PartyRole) + sep;
			if (FixUtils.isSet(nstdPtys4SubGrp.noNested4PartySubIDs)) s += nstdPtys4SubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NestedParties4)) return false;

			NestedParties4 msg = (NestedParties4) o;

		if (!Utils.equals( nested4PartyID, msg.nested4PartyID)) return false;

		if (!( nested4PartyIDSource==msg.nested4PartyIDSource)) return false;

		if (!( nested4PartyRole==msg.nested4PartyRole)) return false;

		if (!nstdPtys4SubGrp.equals(msg.nstdPtys4SubGrp)) return false;

		return true;
	}
}
}
