package org.tomac.protocol.fix.messaging.fix50sp2;

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


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRootParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixListOrdGrp;

public class FixNewOrderList extends FixMessage
{

	public byte[] listID;
	public byte[] bidID;
	public byte[] clientBidID;
	public long progRptReqs = 0;
	public long bidType = 0;
	public long progPeriodInterval = 0;
	public byte cancellationRights = (byte)' ';
	public byte moneyLaunderingStatus = (byte)' ';
	public byte[] registID;
	public byte listExecInstType = (byte)' ';
	public byte[] listExecInst;
	public long contingencyType = 0;
	public long encodedListExecInstLen = 0;
	public byte[] encodedListExecInst;
	public long allowableOneSidednessPct = 0;
	public long allowableOneSidednessValue = 0;
	public byte[] allowableOneSidednessCurr;
	public long totNoOrders = 0;
	public boolean lastFragment = false;
	public FixRootParties rootParties;
	public FixListOrdGrp listOrdGrp;

	public FixNewOrderList() {
		super();

		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		listExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		encodedListExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allowableOneSidednessCurr = new byte[FixUtils.CURRENCY_LENGTH];
		rootParties = new FixRootParties();
		listOrdGrp = new FixListOrdGrp();
		this.clear();

		msgType = MsgTypes.NEWORDERLIST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( listID, (byte)0 );
		Utils.fill( bidID, (byte)0 );
		Utils.fill( clientBidID, (byte)0 );
		progRptReqs = Long.MAX_VALUE;		
		bidType = Long.MAX_VALUE;		
		progPeriodInterval = Long.MAX_VALUE;		
		cancellationRights = Byte.MAX_VALUE;		
		moneyLaunderingStatus = Byte.MAX_VALUE;		
		Utils.fill( registID, (byte)0 );
		listExecInstType = Byte.MAX_VALUE;		
		Utils.fill( listExecInst, (byte)0 );
		contingencyType = Long.MAX_VALUE;		
		encodedListExecInstLen = Long.MAX_VALUE;		
		Utils.fill( encodedListExecInst, (byte)0 );
		allowableOneSidednessPct = Long.MAX_VALUE;		
		allowableOneSidednessValue = Long.MAX_VALUE;		
		Utils.fill( allowableOneSidednessCurr, (byte)0 );
		totNoOrders = Long.MAX_VALUE;		
		lastFragment = false;		
		rootParties.clear();
		listOrdGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.LISTID_INT:
				listID = FixUtils.getTagStringValue(value, listID);
				break;

			case FixTags.BIDID_INT:
				bidID = FixUtils.getTagStringValue(value, bidID);
				break;

			case FixTags.CLIENTBIDID_INT:
				clientBidID = FixUtils.getTagStringValue(value, clientBidID);
				break;

			case FixTags.PROGRPTREQS_INT:
				progRptReqs = FixUtils.getTagIntValue( value );
				if (!ProgRptReqs.isValid(progRptReqs) ) throw new FixSessionException(buf, "Invalid enumerated value(" + progRptReqs + ") for tag: " + id );
				break;

			case FixTags.BIDTYPE_INT:
				bidType = FixUtils.getTagIntValue( value );
				if (!BidType.isValid(bidType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + bidType + ") for tag: " + id );
				break;

			case FixTags.PROGPERIODINTERVAL_INT:
				progPeriodInterval = FixUtils.getTagIntValue( value );
				break;

			case FixTags.CANCELLATIONRIGHTS_INT:
				cancellationRights = FixUtils.getTagCharValue( value );
				if (!CancellationRights.isValid(cancellationRights) ) throw new FixSessionException(buf, "Invalid enumerated value(" + cancellationRights + ") for tag: " + id );
				break;

			case FixTags.MONEYLAUNDERINGSTATUS_INT:
				moneyLaunderingStatus = FixUtils.getTagCharValue( value );
				if (!MoneyLaunderingStatus.isValid(moneyLaunderingStatus) ) throw new FixSessionException(buf, "Invalid enumerated value(" + moneyLaunderingStatus + ") for tag: " + id );
				break;

			case FixTags.REGISTID_INT:
				registID = FixUtils.getTagStringValue(value, registID);
				break;

			case FixTags.LISTEXECINSTTYPE_INT:
				listExecInstType = FixUtils.getTagCharValue( value );
				if (!ListExecInstType.isValid(listExecInstType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + listExecInstType + ") for tag: " + id );
				break;

			case FixTags.LISTEXECINST_INT:
				listExecInst = FixUtils.getTagStringValue(value, listExecInst);
				break;

			case FixTags.CONTINGENCYTYPE_INT:
				contingencyType = FixUtils.getTagIntValue( value );
				if (!ContingencyType.isValid(contingencyType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + contingencyType + ") for tag: " + id );
				break;

			case FixTags.ENCODEDLISTEXECINSTLEN_INT:
				encodedListExecInstLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.ENCODEDLISTEXECINST_INT:
				encodedListExecInst = FixUtils.getTagStringValue(value, encodedListExecInst);
				break;

			case FixTags.ALLOWABLEONESIDEDNESSPCT_INT:
				allowableOneSidednessPct = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.ALLOWABLEONESIDEDNESSVALUE_INT:
				allowableOneSidednessValue = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.ALLOWABLEONESIDEDNESSCURR_INT:
				allowableOneSidednessCurr = FixUtils.getTagStringValue(value, allowableOneSidednessCurr);
				break;

			case FixTags.TOTNOORDERS_INT:
				totNoOrders = FixUtils.getTagIntValue( value );
				break;

			case FixTags.LASTFRAGMENT_INT:
				lastFragment = FixUtils.getTagBooleanValue( value );
				if (!LastFragment.isValid(lastFragment) ) throw new FixSessionException(buf, "Invalid enumerated value(" + lastFragment + ") for tag: " + id );
				break;

			case FixTags.NOROOTPARTYIDS_INT:
				rootParties.noRootPartyIDs = FixUtils.getTagIntValue( value );
				rootParties.getAll(rootParties.noRootPartyIDs, value );
				break;

			case FixTags.NOORDERS_INT:
				listOrdGrp.noOrders = FixUtils.getTagIntValue( value );
				listOrdGrp.getAll(listOrdGrp.noOrders, value );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(listID) ) return FixTags.LISTID_INT;
		if (! FixUtils.isSet(bidType) ) return FixTags.BIDTYPE_INT;
		if (! FixUtils.isSet(totNoOrders) ) return FixTags.TOTNOORDERS_INT;
		if (! listOrdGrp.isSet() ) return FixTags.NOORDERS_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.NEWORDERLIST);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		FixUtils.putFixTag( out, FixTags.LISTID_INT, listID, 0, Utils.lastIndexTrim(listID, (byte)0) );
		if (FixUtils.isSet(bidID)) FixUtils.putFixTag( out, FixTags.BIDID_INT, bidID, 0, Utils.lastIndexTrim(bidID, (byte)0) );
		if (FixUtils.isSet(clientBidID)) FixUtils.putFixTag( out, FixTags.CLIENTBIDID_INT, clientBidID, 0, Utils.lastIndexTrim(clientBidID, (byte)0) );
		if (FixUtils.isSet(progRptReqs)) FixUtils.putFixTag( out, FixTags.PROGRPTREQS_INT, progRptReqs);
		FixUtils.putFixTag( out, FixTags.BIDTYPE_INT, bidType);
		if (FixUtils.isSet(progPeriodInterval)) FixUtils.putFixTag( out, FixTags.PROGPERIODINTERVAL_INT, progPeriodInterval);
		if (FixUtils.isSet(cancellationRights)) FixUtils.putFixTag( out, FixTags.CANCELLATIONRIGHTS_INT, cancellationRights );
		if (FixUtils.isSet(moneyLaunderingStatus)) FixUtils.putFixTag( out, FixTags.MONEYLAUNDERINGSTATUS_INT, moneyLaunderingStatus );
		if (FixUtils.isSet(registID)) FixUtils.putFixTag( out, FixTags.REGISTID_INT, registID, 0, Utils.lastIndexTrim(registID, (byte)0) );
		if (FixUtils.isSet(listExecInstType)) FixUtils.putFixTag( out, FixTags.LISTEXECINSTTYPE_INT, listExecInstType );
		if (FixUtils.isSet(listExecInst)) FixUtils.putFixTag( out, FixTags.LISTEXECINST_INT, listExecInst, 0, Utils.lastIndexTrim(listExecInst, (byte)0) );
		if (FixUtils.isSet(contingencyType)) FixUtils.putFixTag( out, FixTags.CONTINGENCYTYPE_INT, contingencyType);
		if (FixUtils.isSet(encodedListExecInstLen)) FixUtils.putFixTag( out, FixTags.ENCODEDLISTEXECINSTLEN_INT, encodedListExecInstLen);
		if (FixUtils.isSet(encodedListExecInst)) FixUtils.putFixTag( out, FixTags.ENCODEDLISTEXECINST_INT, encodedListExecInst, 0, Utils.lastIndexTrim(encodedListExecInst, (byte)0) );
		if (FixUtils.isSet(allowableOneSidednessPct)) FixUtils.putFixFloatTag( out, FixTags.ALLOWABLEONESIDEDNESSPCT_INT, allowableOneSidednessPct);
		if (FixUtils.isSet(allowableOneSidednessValue)) FixUtils.putFixTag( out, FixTags.ALLOWABLEONESIDEDNESSVALUE_INT, allowableOneSidednessValue);
		if (FixUtils.isSet(allowableOneSidednessCurr)) FixUtils.putFixTag( out, FixTags.ALLOWABLEONESIDEDNESSCURR_INT, allowableOneSidednessCurr, 0, Utils.lastIndexTrim(allowableOneSidednessCurr, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TOTNOORDERS_INT, totNoOrders);
		if (FixUtils.isSet(lastFragment)) FixUtils.putFixTag( out, FixTags.LASTFRAGMENT_INT, lastFragment?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(rootParties.noRootPartyIDs)) rootParties.encode( out );
		listOrdGrp.encode( out );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.NEWORDERLIST) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			 s += "ListID(66)=" + new String(listID) + sep;
			if (FixUtils.isSet(bidID)) s += "BidID(390)=" + new String(bidID) + sep;
			if (FixUtils.isSet(clientBidID)) s += "ClientBidID(391)=" + new String(clientBidID) + sep;
			if (FixUtils.isSet(progRptReqs)) s += "ProgRptReqs(414)=" + String.valueOf(progRptReqs) + sep;
			 s += "BidType(394)=" + String.valueOf(bidType) + sep;
			if (FixUtils.isSet(progPeriodInterval)) s += "ProgPeriodInterval(415)=" + String.valueOf(progPeriodInterval) + sep;
			if (FixUtils.isSet(cancellationRights)) s += "CancellationRights(480)=" + String.valueOf(cancellationRights) + sep;
			if (FixUtils.isSet(moneyLaunderingStatus)) s += "MoneyLaunderingStatus(481)=" + String.valueOf(moneyLaunderingStatus) + sep;
			if (FixUtils.isSet(registID)) s += "RegistID(513)=" + new String(registID) + sep;
			if (FixUtils.isSet(listExecInstType)) s += "ListExecInstType(433)=" + String.valueOf(listExecInstType) + sep;
			if (FixUtils.isSet(listExecInst)) s += "ListExecInst(69)=" + new String(listExecInst) + sep;
			if (FixUtils.isSet(contingencyType)) s += "ContingencyType(1385)=" + String.valueOf(contingencyType) + sep;
			if (FixUtils.isSet(encodedListExecInstLen)) s += "EncodedListExecInstLen(352)=" + String.valueOf(encodedListExecInstLen) + sep;
			if (FixUtils.isSet(encodedListExecInst)) s += "EncodedListExecInst(353)=" + new String(encodedListExecInst) + sep;
			if (FixUtils.isSet(allowableOneSidednessPct)) s += "AllowableOneSidednessPct(765)=" + String.valueOf(allowableOneSidednessPct) + sep;
			if (FixUtils.isSet(allowableOneSidednessValue)) s += "AllowableOneSidednessValue(766)=" + String.valueOf(allowableOneSidednessValue) + sep;
			if (FixUtils.isSet(allowableOneSidednessCurr)) s += "AllowableOneSidednessCurr(767)=" + new String(allowableOneSidednessCurr) + sep;
			 s += "TotNoOrders(68)=" + String.valueOf(totNoOrders) + sep;
			if (FixUtils.isSet(lastFragment)) s += "LastFragment(893)=" + String.valueOf(lastFragment) + sep;
			if (FixUtils.isSet(rootParties.noRootPartyIDs)) s += rootParties.toString();
			 s += listOrdGrp.toString();

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNewOrderList)) return false;

			FixNewOrderList msg = (FixNewOrderList) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( listID, msg.listID)) return false;

		if (!Utils.equals( bidID, msg.bidID)) return false;

		if (!Utils.equals( clientBidID, msg.clientBidID)) return false;

		if (!( progRptReqs==msg.progRptReqs)) return false;

		if (!( bidType==msg.bidType)) return false;

		if (!( progPeriodInterval==msg.progPeriodInterval)) return false;

		if (!( cancellationRights==msg.cancellationRights)) return false;

		if (!( moneyLaunderingStatus==msg.moneyLaunderingStatus)) return false;

		if (!Utils.equals( registID, msg.registID)) return false;

		if (!( listExecInstType==msg.listExecInstType)) return false;

		if (!Utils.equals( listExecInst, msg.listExecInst)) return false;

		if (!( contingencyType==msg.contingencyType)) return false;

		if (!( encodedListExecInstLen==msg.encodedListExecInstLen)) return false;

		if (!Utils.equals( encodedListExecInst, msg.encodedListExecInst)) return false;

		if (!( allowableOneSidednessPct==msg.allowableOneSidednessPct)) return false;

		if (!( allowableOneSidednessValue==msg.allowableOneSidednessValue)) return false;

		if (!Utils.equals( allowableOneSidednessCurr, msg.allowableOneSidednessCurr)) return false;

		if (!( totNoOrders==msg.totNoOrders)) return false;

		if (!( lastFragment==msg.lastFragment)) return false;

		if (!rootParties.equals(msg.rootParties)) return false;

		if (!listOrdGrp.equals(msg.listOrdGrp)) return false;

		return true;
	}
}