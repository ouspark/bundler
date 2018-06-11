package com.akkoid
package mui

import ammonite.ops._

import scala.language.implicitConversions

case class MuiLibrary(base: Path) extends Library {
  /* todo: make requiresjs clever enough to figure this out by itself */
  override val locations =
    Seq(
      base,
      base / 'styles,
      base / 'internal / 'SwitchBase
    )

  override val prefixOpt    = Some("Mui")
  override val name         = "materialui"
  override val typeMapper   = MuiTypeMapper
  override val memberMapper = MuiTypeMemberMethodMapper
  override val indexNames   = Set("index.js")
  override val packageName  = "com.akkoid.components.materialui"

  case object Internal {
    val SwitchBase = ComponentDef(CompName("SwitchBase"))
  }

  val ButtonBase = ComponentDef(CompName("ButtonBase"))
  val IconButton = ComponentDef(CompName("IconButton"), Option(ButtonBase))
  val Input      = ComponentDef(CompName("Input"))
  val Drawer     = ComponentDef(CompName("Drawer"))
  val FormLabel  = ComponentDef(CompName("FormLabel"))
  val FormGroup  = ComponentDef(CompName("FormGroup"))
  val FormControl= ComponentDef(CompName("FormControl"))
  val List_      = ComponentDef(CompName("List"))
  val ListItem   = ComponentDef(CompName("ListItem"))
  val Paper      = ComponentDef(CompName("Paper"))
//  val Portal     = ComponentDef(CompName("Portal"))
//  val Modal      = ComponentDef(CompName("Modal"), Option(Portal))
//  val Popover    = ComponentDef(CompName("Popover"), Option(Modal))
  val TableCell  = ComponentDef(CompName("TableCell"))
  val Typography = ComponentDef(CompName("Typography"))


  val components: Seq[ComponentDef] =
    Seq(
      ComponentDef(CompName("AppBar"), Option(Paper)),
      ComponentDef(CompName("Avatar"), multipleChildren = false),
      ComponentDef(CompName("Backdrop")),
      ComponentDef(CompName("Badge")),
      ComponentDef(CompName("BottomNavigation")),
      ComponentDef(CompName("BottomNavigationAction"), Option(ButtonBase)),
      ComponentDef(CompName("Button"), Option(ButtonBase)),
      ButtonBase,
      ComponentDef(CompName("Card"), Some(Paper)),
      ComponentDef(CompName("CardActions")),
      ComponentDef(CompName("CardContent")),
      ComponentDef(CompName("CardHeader")),
      ComponentDef(CompName("CardMedia")),
      ComponentDef(CompName("Checkbox")),
      ComponentDef(CompName("Chip")),
      ComponentDef(CompName("CircularProgress")),
//      ComponentDef(CompName("ClickAwayListener"), Option(EventListener),
//      ComponentDef(CompName("Collapse"), Option(Transition)),
      ComponentDef(CompName("CssBaseline")),
//      ComponentDef(CompName("Dialog"), Option(Modal)),
      ComponentDef(CompName("DialogActions")),
      ComponentDef(CompName("DialogContent")),
      ComponentDef(CompName("DialogContentText"), Option(Typography)),
      ComponentDef(CompName("DialogTitle")),
      ComponentDef(CompName("Divider")),
      Drawer,
      ComponentDef(CompName("ExpansionPanel"), Option(Paper)),
      ComponentDef(CompName("ExpansionPanelActions")),
      ComponentDef(CompName("ExpansionPanelDetails")),
      ComponentDef(CompName("ExpansionPanelSummary"), Option(ButtonBase)),
//      ComponentDef(CompName("Fade"), Option(Transition)),
      FormControl,
      ComponentDef(CompName("FormControlLabel")),
      FormGroup,
      ComponentDef(CompName("FormHelperText")),
      FormLabel,
      ComponentDef(CompName("Grid")),
      ComponentDef(CompName("GridList")),
      ComponentDef(CompName("GridListTile")),
      ComponentDef(CompName("GridListTileBar")),
//      ComponentDef(CompName("Grow"), Option(Transition)),
      ComponentDef(CompName("Hidden")),
      ComponentDef(CompName("Icon")),
      IconButton,
      Input,
      ComponentDef(CompName("InputAdornment")),
      ComponentDef(CompName("InputLabel"), Option(FormLabel)),
      ComponentDef(CompName("LinearProgress")),
      List_,
      ListItem,
      ComponentDef(CompName("ListItemAvatar")),
      ComponentDef(CompName("ListItemIcon")),
      ComponentDef(CompName("ListItemSecondaryAction")),
      ComponentDef(CompName("ListItemText")),
      ComponentDef(CompName("ListSubheader")),
//      ComponentDef(CompName("Menu"), Option(Popover)),
      ComponentDef(CompName("MenuItem"), Option(ListItem)),
      ComponentDef(CompName("MenuList"), Option(List_)),
      ComponentDef(CompName("MobileStepper"), Option(Paper)),
//      Modal,
      ComponentDef(CompName("MuiThemeProvider")),
      ComponentDef(CompName("NativeSelect"), Option(Input)),
      Paper,
//      Popover,
//      Portal,
      ComponentDef(CompName("Radio")),
      ComponentDef(CompName("RadioGroup"), Option(FormGroup)),
      ComponentDef(CompName("RootRef")),
      ComponentDef(CompName("Select"), Option(Input)),
//      ComponentDef(CompName("Slide"), Option(Transition)),
      ComponentDef(CompName("Snackbar")),
      ComponentDef(CompName("SnackbarContent"), Option(Paper)),
      ComponentDef(CompName("Step")),
      ComponentDef(CompName("StepButton"), Option(ButtonBase)),
      ComponentDef(CompName("StepConnector")),
      ComponentDef(CompName("StepContent")),
      ComponentDef(CompName("StepIcon")),
      ComponentDef(CompName("StepLabel")),
      ComponentDef(CompName("Stepper"), Option(Paper)),
      ComponentDef(CompName("SvgIcon")),
      ComponentDef(CompName("SwipeableDrawer"), Option(Drawer)),
      ComponentDef(CompName("Switch")),
      ComponentDef(CompName("SwitchBase"), Option(IconButton)),
      ComponentDef(CompName("Tab"), Option(ButtonBase)),
      ComponentDef(CompName("Table")),
      ComponentDef(CompName("TableBody")),
      TableCell,
      ComponentDef(CompName("TableFooter")),
      ComponentDef(CompName("TableHead")),
      ComponentDef(CompName("TablePagination"), Option(TableCell)),
      ComponentDef(CompName("TableRow")),
      ComponentDef(CompName("TableSortLabel"), Option(ButtonBase)),
      ComponentDef(CompName("Tabs")),
      ComponentDef(CompName("TextField"), Option(FormControl)),
      ComponentDef(CompName("Toolbar")),
      ComponentDef(CompName("Tooltip")),
      ComponentDef(CompName("TouchRipple")),
      Typography,
      ComponentDef(CompName("Zoom")),

    )
}
