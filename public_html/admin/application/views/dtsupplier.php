<style media="screen">
div#zero-config_filter {
  text-align: right;
}
a.page-link {
    height: 40px;
}
</style>
        <!--  END SIDEBAR  -->

        <!--  BEGIN CONTENT AREA  -->
        <div id="content" class="main-content">
            <div class="layout-px-spacing">

                <div class="page-header">
                    <div class="page-title">
                        <h3>Light</h3>
                    </div>
                </div>

                <div class="row" id="cancel-row">

                    <div class="col-xl-12 col-lg-12 col-sm-12  layout-spacing">
                        <div class="widget-content widget-content-area br-6">
                            <div class="table-responsive mb-4 mt-4">
                                <table id="zero-config" class="table table-hover" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>Supplier Code</th>
                                            <th>Supplier Name</th>
                                            <th>Supplier Address</th>
                                            <th class="no-content"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                      <?php
                                      if(!empty($supplier))
                                      {
                                          foreach($supplier as $sp)
                                          {
                                      ?>
                                      <tr>
                                          <td><?php echo $sp->STRVENDOR_CODE; ?></td>
                                          <td><?php echo $sp->STRVENDOR_NAME; ?></td>
                                          <td><?php echo $sp->STRDESCRIPTION; ?></td>
                                          <td></td>
                                      </tr>
                                      <!-- <tr>
                                          <td><?php echo $record->name ?></td>
                                          <td><?php echo $record->email ?></td>
                                          <td><?php echo $record->mobile ?></td>
                                          <td><?php echo $record->role ?></td>
                                          <td><?php echo date("d-m-Y", strtotime($record->createdDtm)) ?></td>
                                          <td class="text-center">
                                              <a class="btn btn-sm btn-primary" href="<?= base_url().'login-history/'.$record->userId; ?>" title="Login history"><i class="fa fa-history"></i></a> |
                                              <a class="btn btn-sm btn-info" href="<?php echo base_url().'editOld/'.$record->userId; ?>" title="Edit"><i class="fa fa-pencil"></i></a>
                                              <a class="btn btn-sm btn-danger deleteUser" href="#" data-userid="<?php echo $record->userId; ?>" title="Delete"><i class="fa fa-trash"></i></a>
                                          </td>
                                      </tr> -->
                                      <?php
                                          }
                                      }
                                      ?>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                          <th>Supplier Code</th>
                                          <th>Supplier Name</th>
                                          <th>Supplier Address</th>
                                          <th class="no-content"></th>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <!--  END CONTENT AREA  -->
    </div>
    <!-- END MAIN CONTAINER -->

    <!-- BEGIN GLOBAL MANDATORY SCRIPTS -->
    <script src="assets/js/libs/jquery-3.1.1.min.js"></script>
    <script src="bootstrap/js/popper.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="assets/js/app.js"></script>

    <script>
        $(document).ready(function() {
            App.init();
        });
    </script>
    <script src="assets/js/custom.js"></script>
    <!-- END GLOBAL MANDATORY SCRIPTS -->

    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="plugins/table/datatable/datatables.js"></script>
    <script>
        $('#zero-config').DataTable({
            "oLanguage": {
                "oPaginate": { "sPrevious": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>', "sNext": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>' },
                "sInfo": "Showing page _PAGE_ of _PAGES_",
                "sSearch": '',
                "sSearchPlaceholder": "Search...",
               "sLengthMenu": "Results :  _MENU_",
            },
            "stripeClasses": [],
            "lengthMenu": [7, 10, 20, 50],
            "pageLength": 7
        });
    </script>
    <!-- END PAGE LEVEL SCRIPTS -->
</body>
</html>
