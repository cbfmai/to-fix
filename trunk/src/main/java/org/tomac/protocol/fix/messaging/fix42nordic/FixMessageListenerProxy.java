package org.tomac.protocol.fix.messaging.fix42nordic;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;
public class FixMessageListenerProxy implements FixMessageListener
{

	FixMessageListener sessionLayer;
	FixMessageListener applicationLayer;

	public FixMessageListenerProxy(FixMessageListener l1, FixMessageListener l2) {
		this.sessionLayer = l1;
		this.applicationLayer = l2;
	}

	@Override
	public void onUnknownMessageType(FixMessage msg) {
		sessionLayer.onUnknownMessageType(msg);
		applicationLayer.onUnknownMessageType(msg);
	}

	@Override
	public void onFixAcceptedCancelReplace( FixAcceptedCancelReplace msg ) {
		sessionLayer.onFixAcceptedCancelReplace( msg );
		applicationLayer.onFixAcceptedCancelReplace( msg );
	}

	@Override
	public void onFixAcceptedCancel( FixAcceptedCancel msg ) {
		sessionLayer.onFixAcceptedCancel( msg );
		applicationLayer.onFixAcceptedCancel( msg );
	}

	@Override
	public void onFixApplicationReject( FixApplicationReject msg ) {
		sessionLayer.onFixApplicationReject( msg );
		applicationLayer.onFixApplicationReject( msg );
	}

	@Override
	public void onFixBreakNotification( FixBreakNotification msg ) {
		sessionLayer.onFixBreakNotification( msg );
		applicationLayer.onFixBreakNotification( msg );
	}

	@Override
	public void onFixBusinessReject( FixBusinessReject msg ) {
		sessionLayer.onFixBusinessReject( msg );
		applicationLayer.onFixBusinessReject( msg );
	}

	@Override
	public void onFixCancelNotification( FixCancelNotification msg ) {
		sessionLayer.onFixCancelNotification( msg );
		applicationLayer.onFixCancelNotification( msg );
	}

	@Override
	public void onFixEntryNotificationtoAllegedFirm( FixEntryNotificationtoAllegedFirm msg ) {
		sessionLayer.onFixEntryNotificationtoAllegedFirm( msg );
		applicationLayer.onFixEntryNotificationtoAllegedFirm( msg );
	}

	@Override
	public void onFixExecutionReportFill( FixExecutionReportFill msg ) {
		sessionLayer.onFixExecutionReportFill( msg );
		applicationLayer.onFixExecutionReportFill( msg );
	}

	@Override
	public void onFixExecutionRestatement( FixExecutionRestatement msg ) {
		sessionLayer.onFixExecutionRestatement( msg );
		applicationLayer.onFixExecutionRestatement( msg );
	}

	@Override
	public void onFixLockedinNotification( FixLockedinNotification msg ) {
		sessionLayer.onFixLockedinNotification( msg );
		applicationLayer.onFixLockedinNotification( msg );
	}

	@Override
	public void onFixLockedinTradeBreak( FixLockedinTradeBreak msg ) {
		sessionLayer.onFixLockedinTradeBreak( msg );
		applicationLayer.onFixLockedinTradeBreak( msg );
	}

	@Override
	public void onFixOrderAcknowledgement( FixOrderAcknowledgement msg ) {
		sessionLayer.onFixOrderAcknowledgement( msg );
		applicationLayer.onFixOrderAcknowledgement( msg );
	}

	@Override
	public void onFixOrderReject( FixOrderReject msg ) {
		sessionLayer.onFixOrderReject( msg );
		applicationLayer.onFixOrderReject( msg );
	}

	@Override
	public void onFixPendingCancel( FixPendingCancel msg ) {
		sessionLayer.onFixPendingCancel( msg );
		applicationLayer.onFixPendingCancel( msg );
	}

	@Override
	public void onFixTradeEntryNotificationtoEnteringFirm( FixTradeEntryNotificationtoEnteringFirm msg ) {
		sessionLayer.onFixTradeEntryNotificationtoEnteringFirm( msg );
		applicationLayer.onFixTradeEntryNotificationtoEnteringFirm( msg );
	}

	@Override
	public void onFixTradeReportCancel( FixTradeReportCancel msg ) {
		sessionLayer.onFixTradeReportCancel( msg );
		applicationLayer.onFixTradeReportCancel( msg );
	}

	@Override
	public void onFixTradeReportEntry( FixTradeReportEntry msg ) {
		sessionLayer.onFixTradeReportEntry( msg );
		applicationLayer.onFixTradeReportEntry( msg );
	}

	@Override
	public void onFixHeartbeat( FixHeartbeat msg ) {
		sessionLayer.onFixHeartbeat( msg );
		applicationLayer.onFixHeartbeat( msg );
	}

	@Override
	public void onFixLogon( FixLogon msg ) {
		sessionLayer.onFixLogon( msg );
		applicationLayer.onFixLogon( msg );
	}

	@Override
	public void onFixLogout( FixLogout msg ) {
		sessionLayer.onFixLogout( msg );
		applicationLayer.onFixLogout( msg );
	}

	@Override
	public void onFixOrderSingle( FixOrderSingle msg ) {
		sessionLayer.onFixOrderSingle( msg );
		applicationLayer.onFixOrderSingle( msg );
	}

	@Override
	public void onFixOrderCancelReject( FixOrderCancelReject msg ) {
		sessionLayer.onFixOrderCancelReject( msg );
		applicationLayer.onFixOrderCancelReject( msg );
	}

	@Override
	public void onFixRejectedCancelReplace( FixRejectedCancelReplace msg ) {
		sessionLayer.onFixRejectedCancelReplace( msg );
		applicationLayer.onFixRejectedCancelReplace( msg );
	}

	@Override
	public void onFixOrderCancelReplaceRequest( FixOrderCancelReplaceRequest msg ) {
		sessionLayer.onFixOrderCancelReplaceRequest( msg );
		applicationLayer.onFixOrderCancelReplaceRequest( msg );
	}

	@Override
	public void onFixOrderCancelRequest( FixOrderCancelRequest msg ) {
		sessionLayer.onFixOrderCancelRequest( msg );
		applicationLayer.onFixOrderCancelRequest( msg );
	}

	@Override
	public void onFixReject( FixReject msg ) {
		sessionLayer.onFixReject( msg );
		applicationLayer.onFixReject( msg );
	}

	@Override
	public void onFixResendRequest( FixResendRequest msg ) {
		sessionLayer.onFixResendRequest( msg );
		applicationLayer.onFixResendRequest( msg );
	}

	@Override
	public void onFixSequenceReset( FixSequenceReset msg ) {
		sessionLayer.onFixSequenceReset( msg );
		applicationLayer.onFixSequenceReset( msg );
	}

	@Override
	public void onFixTestRequest( FixTestRequest msg ) {
		sessionLayer.onFixTestRequest( msg );
		applicationLayer.onFixTestRequest( msg );
	}

}